package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Model;
import com.example.demo.service.Service;

@RestController
public class Controller {
	@Autowired
	Service bs;
	@PostMapping("addnbaby")
	public List<Model> addinfo(@RequestBody List<Model> bm)
	{
		return bs.savedetails(bm);
	}
	//to get the data
	@GetMapping("showbaby")
	public List<Model> show()
	{
		return bs.showinfo();
	}
	@GetMapping("sortbaby/{lastname}")
	public List<Model> getsortinfo(@PathVariable String lastname)
	{
		return bs.sortinfo(lastname);
	}
	@GetMapping("pagingbaby/{pagno}/{pagsize}")
	public List<Model> showpageinfo(@PathVariable int pagno,@PathVariable int pagsize)
	{
		return bs.getbypage(pagno, pagsize);
	}
	@GetMapping("getsortpagbaby/{pagno}/{pagsize}")
	public List<Model> showsortpageinfo(@PathVariable int pagno,@PathVariable int pagsize)
	{
		return bs.getpage(pagno, pagsize);
	}
}