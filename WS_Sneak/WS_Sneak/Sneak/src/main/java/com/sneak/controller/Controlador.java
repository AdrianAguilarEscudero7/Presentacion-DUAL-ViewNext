package com.sneak.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sneak.dao.IConfiguracionDAO;
import com.sneak.modelo.Configuracion;
import com.sneak.modelo.Estadistica;
import com.sneak.modelo.FileModel;
import com.sneak.modelo.Quote;
import com.sneak.services.QuoteService;
import com.sneak.util.ExcelUtil;

@Controller
public class Controlador {
	@Autowired
	IConfiguracionDAO cdao;

	@Autowired
	ServletContext context;
	
	@Autowired
	QuoteService qService;
	
	@Autowired
	ExcelUtil xlsUtil;

	Configuracion c = new Configuracion();
	
	Quote q = new Quote();
	
//	@RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
//	public ModelAndView fileUploadPage() {
//		FileModel file = new FileModel();
//		ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
//		return modelAndView;
//	}
	
	   @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "cargaExcel")
	   public ModelAndView cargaExcel(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException {
	      if (result.hasErrors() || file.getFile().getOriginalFilename().isEmpty() || !file.getFile().getOriginalFilename().endsWith("xlsx") ) {
	    	 q.setMsg("");
	    	 q.setMsg("Introduzca un fichero v�lido.");
	         System.out.println("validation errors");
	         ModelAndView modelAndView = new ModelAndView("index",  "quote", q);    
	         return modelAndView;
	      } else {            
	         System.out.println("Fetching file");
	         q.setMsg("");
	         
	         MultipartFile multipartFile = file.getFile();
	         
//	         String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
	         String uploadPath = context.getRealPath("") + File.separator;
	         // Now do something with file...
	         FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
//	         String fileName = multipartFile.getOriginalFilename() ;
	         String fileName = new File(uploadPath+file.getFile().getOriginalFilename()).getAbsolutePath();
	        
	         q = xlsUtil.cargaExcel(fileName);
	         model.addAttribute("fileName", fileName) ;
	         
	         return new ModelAndView("index", "quote", q);
	      }
	   }

	@RequestMapping("/index")
	public ModelAndView goIndex(@RequestParam(value = "name", required = false) String name) {
		
		q.setMsg("");
			
		ModelAndView mv = new ModelAndView("index", "configuracion", c);
		return mv;
	}
	

	@RequestMapping("/config")
	public ModelAndView goConfig(@RequestParam(value = "name", required = false) String name) {

		c.setMsg("");

		ModelAndView mv = new ModelAndView("config", "configuracion", c);
		return mv;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "select", params = "add")
	public ModelAndView addResponsable(@RequestParam(value = "responsable", required = false) String resp)
			throws Exception {

		c.setMsg("");

		c = cdao.insertResponsable(resp);

		return new ModelAndView("config", "configuracion", c);
	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "select", params = "notSure")
	public ModelAndView notSure(@RequestParam(value = "responsable", required = false) String resp)
			throws Exception {

		c.setMsg("");

		return new ModelAndView("config", "configuracion", c);
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "select", params = "delete")
	public ModelAndView deleteResponsable(@RequestParam(value = "respSelected", required = false) String respSelected)
			throws Exception {

		c.setMsg("");

		c = cdao.deleteResponsable(respSelected);

		return new ModelAndView("config", "configuracion", c);
	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "respCarga")
	public ModelAndView respCargaStats(@RequestParam(value = "respSelected", required = false) String respSelected)
			throws Exception {
		
//		System.out.println("Hola " + respSelected);
		Estadistica estadisticas = new Estadistica();
		
		String msg = xlsUtil.updtDatosResponsable(respSelected);
		
		if (msg == "�No se puede actualizar sin antes cargar un reparto!.") {
			estadisticas.setMsg(msg);
		} else {
		
			estadisticas.setResponsable("");
		
			estadisticas = xlsUtil.generaEstadisticas(respSelected);
		
		}
		
		return new ModelAndView("index","estadisticas", estadisticas);
	}
}
