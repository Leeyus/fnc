package com.iu.board.fmedia;

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
public class FmediaService {
	@Inject
	private FmediaDAO fmediaDAO;
	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView list(Pager pager)throws Exception{
		pager.makeRow();
		int totalCount = fmediaDAO.totalCount(pager);
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
		
		mv.addObject("list", fmediaDAO.list(pager));
		mv.addObject("pager", pager);
		
		return mv;
	}
	//select
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		FmediaDTO fmediaDTO = fmediaDAO.select(num);
		
		if(fmediaDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", fmediaDTO);
		}else {
			mv.setViewName("redirect:./fmediaList");
		}
		mv.addObject("board", "fmedia");
		
		return mv;
	}
	
	//insert
	public ModelAndView insert(FmediaDTO fmediaDTO,List<MultipartFile> f1, HttpSession session)throws Exception{
		int num = fmediaDAO.getNum();
		
		fmediaDTO.setNum(num);
		int result = fmediaDAO.insert(fmediaDTO);
		
		//transaction 처리
				if(result<1) {
					throw new Exception();
				}
				
				//3. HDD에 File 저장
				FileSaver fs = new FileSaver();
				String realPath = session.getServletContext().getRealPath("resources/fmedia");//저장 경로 realPath
				
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
					fileDTO.setKind("p");
					result = fileDAO.insert(fileDTO);
					
					//transaction
					if(result<1) {
						throw new Exception();
					}
				}
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("redirect:./fmediaList");
				mv.addObject("msg", "Write Success");
				return mv;
			}
	
	public ModelAndView update(FmediaDTO fmediaDTO,List<MultipartFile> f1, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = fmediaDAO.update(fmediaDTO);
		
		if(result<1) {
			throw new Exception();
		}
		//HDD save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/fmedia");
		for(MultipartFile multipartFile:f1) {
			String fname = fs.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(fmediaDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind("p");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
			String msg = "Update Success";
		
		mv.setViewName("redirect:./fmediaSelect?num="+fmediaDTO.getNum());
		mv.addObject("msg", msg);
		return mv;
	}
	
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		//1.notice Delete
		int result = fmediaDAO.delete(num);
		if(result<1) {
			throw new Exception();
		}
		
		//2. HDD Delete준비
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("p");
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		//3.Files Delete
		result = fileDAO.deleteAll(fileDTO);
		
		//4. HDD Delete
		String realPath = session.getServletContext().getRealPath("resources/fmedia");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		
		mv.setViewName("redirect:./fmediaList");
		mv.addObject("msg", "Delete Success");
		
		return mv;
	}
	
	
	
}
