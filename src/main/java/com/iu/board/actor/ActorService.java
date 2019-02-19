package com.iu.board.actor;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.release.ReleaseDTO;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.Pager;

@Service
public class ActorService {

	@Inject
	private ActorDAO actorDAO;
	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView list(Pager pager)throws Exception{
		pager.makeRow();
		int totalCount = actorDAO.totalCount(pager);
		System.out.println("totalcount : "+totalCount);
		pager.makePage(totalCount);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardList3");
		/*
		System.out.println(pager.getLastNum());
		System.out.println(pager.getStartNum());
		System.out.println(pager.getTotalPage());
		System.out.println(pager.getTotalBlock());
		System.out.println(pager.getPerPage());*/
		
		mv.addObject("list", actorDAO.list(pager));
		mv.addObject("pager", pager);
		
		return mv;
	}
	
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		ActorDTO actorDTO = actorDAO.select(num);
		
		if(actorDTO != null) {
			mv.setViewName("board/boardSelect2");
			mv.addObject("dto", actorDTO);
		}else {
			mv.setViewName("redirect:./actorList");
		}
		mv.addObject("board", "actor");
		
		return mv;
	}
	
	
	public ModelAndView insert(ActorDTO actorDTO,List<MultipartFile> f1, HttpSession session)throws Exception{
		int num = actorDAO.getNum();
		
		actorDTO.setNum(num);
		int result = actorDAO.insert(actorDTO);
		
		//transaction 처리
				if(result<1) {
					throw new Exception();
				}
				
				//3. HDD에 File 저장
				FileSaver fs = new FileSaver();
				String realPath = session.getServletContext().getRealPath("resources/actor");//저장 경로 realPath
				
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
					fileDTO.setKind("a");
					result = fileDAO.insert(fileDTO);
					
					//transaction
					if(result<1) {
						throw new Exception();
					}
				}
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("redirect:./actorList");
				mv.addObject("msg", "Write Success");
				return mv;
		
	}
	
	public ModelAndView update(ActorDTO actorDTO,List<MultipartFile>f1, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = actorDAO.update(actorDTO);
		
		if(result<1) {
			throw new Exception();
		}
		//HDD save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/actor");
		for(MultipartFile multipartFile:f1) {
			String fname = fs.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(actorDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind("a");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
			String msg = "Update Success";
		
		mv.setViewName("redirect:./actorSelect?num="+actorDTO.getNum());
		mv.addObject("msg", msg);
		return mv;
	}
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = actorDAO.delete(num);
		if(result<1) {
			throw new Exception();
		}
		
		//2. HDD Delete준비
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("a");
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		//3.Files Delete
		result = fileDAO.deleteAll(fileDTO);
		
		//4. HDD Delete
		String realPath = session.getServletContext().getRealPath("resources/actor");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		
		mv.setViewName("redirect:./actorList");
		mv.addObject("msg", "Delete Success");
		
		return mv;
	}
	
}
