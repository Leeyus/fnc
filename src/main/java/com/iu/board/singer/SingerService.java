package com.iu.board.singer;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.actor.ActorDAO;
import com.iu.board.actor.ActorDTO;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.Pager;
import com.iu.util.Pager2;

@Service
public class SingerService {
	@Inject
	private SingerDAO singerDAO;
	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView list(Pager2 pager2)throws Exception{
		pager2.makeRow();
		int totalCount = singerDAO.totalCount(pager2);
		pager2.makePage(totalCount);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardList4");
		
		mv.addObject("list", singerDAO.list(pager2));
		mv.addObject("pager", pager2);
		
		return mv;
	}
	
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		SingerDTO singerDTO = singerDAO.select(num);
		
		if(singerDTO != null) {
			mv.setViewName("board/boardSelect3");
			mv.addObject("dto", singerDTO);
		}else {
			mv.setViewName("redirect:./singerList");
		}
		mv.addObject("board", "singer");
		
		return mv;
	}
	
	
	public ModelAndView insert(SingerDTO singerDTO,List<MultipartFile> f1, HttpSession session)throws Exception{
		int num = singerDAO.getNum();
		
		singerDTO.setNum(num);
		int result = singerDAO.insert(singerDTO);
		
		//transaction 처리
				if(result<1) {
					throw new Exception();
				}
				
				//3. HDD에 File 저장
				FileSaver fs = new FileSaver();
				String realPath = session.getServletContext().getRealPath("resources/singer");//저장 경로 realPath
				
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
					fileDTO.setKind("s");
					result = fileDAO.insert(fileDTO);
					
					//transaction
					if(result<1) {
						throw new Exception();
					}
				}
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("redirect:./singerList");
				mv.addObject("msg", "Write Success");
				return mv;
		
	}
	
	public ModelAndView update(SingerDTO singerDTO,List<MultipartFile>f1, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = singerDAO.update(singerDTO);
		
		if(result<1) {
			throw new Exception();
		}
		//HDD save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/singer");
		for(MultipartFile multipartFile:f1) {
			String fname = fs.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(singerDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind("s");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
			String msg = "Update Success";
		
		mv.setViewName("redirect:./singerSelect?num="+singerDTO.getNum());
		mv.addObject("msg", msg);
		return mv;
	}
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = singerDAO.delete(num);
		if(result<1) {
			throw new Exception();
		}
		
		//2. HDD Delete준비
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("s");
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		//3.Files Delete
		result = fileDAO.deleteAll(fileDTO);
		
		//4. HDD Delete
		String realPath = session.getServletContext().getRealPath("resources/singer");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		
		mv.setViewName("redirect:./singerList");
		mv.addObject("msg", "Delete Success");
		
		return mv;
	}
}
