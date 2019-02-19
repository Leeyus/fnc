package com.iu.board.release;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.iu.board.BoardDTO;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.Pager;

@Service
public class ReleaseService {
	@Inject
	private ReleaseDAO releaseDAO;
	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView list(Pager pager)throws Exception{
		pager.makeRow();
		int totalCount = releaseDAO.totalCount(pager);
		System.out.println("totalcount : "+totalCount);
		pager.makePage(totalCount);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardList2");
		/*
		System.out.println(pager.getLastNum());
		System.out.println(pager.getStartNum());
		System.out.println(pager.getTotalPage());
		System.out.println(pager.getTotalBlock());
		System.out.println(pager.getPerPage());*/
		
		mv.addObject("list", releaseDAO.list(pager));
		mv.addObject("pager", pager);
		
		return mv;
	}
	//select
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		ReleaseDTO releaseDTO = releaseDAO.select(num);
		
		if(releaseDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", releaseDTO);
		}else {
			mv.setViewName("redirect:./releaseList");
		}
		mv.addObject("board", "release");
		
		return mv;
	}
	
	//insert
	public ModelAndView insert(ReleaseDTO releaseDTO,List<MultipartFile> f1, HttpSession session)throws Exception{
		int num = releaseDAO.getNum();
		
		releaseDTO.setNum(num);
		int result = releaseDAO.insert(releaseDTO);
		
		//transaction 처리
				if(result<1) {
					throw new Exception();
				}
				
				//3. HDD에 File 저장
				FileSaver fs = new FileSaver();
				String realPath = session.getServletContext().getRealPath("resources/release");//저장 경로 realPath
				
				for(MultipartFile multipartFile :f1) {
					if(multipartFile==null || multipartFile.isEmpty()) {
						continue;
					}
					String fname = fs.saveFile(realPath, multipartFile);
				//4. Files 테이블에 insert
					FileDTO fileDTO = new FileDTO();
					fileDTO.setNum(num);
					fileDTO.setFname(fname);
					fileDTO.setOname(multipartFile.getOriginalFilename());
					fileDTO.setKind("r");
					result = fileDAO.insert(fileDTO);
					
					//transaction
					if(result<1) {
						throw new Exception();
					}
				}
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("redirect:./releaseList");
				mv.addObject("msg", "Write Success");
				return mv;
			}
	
	public ModelAndView update(ReleaseDTO releaseDTO,List<MultipartFile> f1, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = releaseDAO.update(releaseDTO);
		
		if(result<1) {
			throw new Exception();
		}
		//HDD save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/release");
		for(MultipartFile multipartFile:f1) {
			String fname = fs.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(releaseDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind("r");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
			String msg = "Update Success";
		
		mv.setViewName("redirect:./releaseSelect?num="+releaseDTO.getNum());
		mv.addObject("msg", msg);
		return mv;
	}
	
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		//1.notice Delete
		int result = releaseDAO.delete(num);
		if(result<1) {
			throw new Exception();
		}
		
		//2. HDD Delete준비
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("r");
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		//3.Files Delete
		result = fileDAO.deleteAll(fileDTO);
		
		//4. HDD Delete
		String realPath = session.getServletContext().getRealPath("resources/release");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		
		mv.setViewName("redirect:./releaseList");
		mv.addObject("msg", "Delete Success");
		
		return mv;
	}
	
	
	
}
