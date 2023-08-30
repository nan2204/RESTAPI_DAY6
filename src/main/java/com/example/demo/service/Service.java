package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.demo.model.Model;
import com.example.demo.repository.Repo;
@org.springframework.stereotype.Service
public class Service {

		@Autowired
		Repo br;
		public List<Model> savedetails(List<Model> bm)
		{
			return (List<Model>)br.saveAll(bm);
		}
		public List<Model> showinfo(){
			return br.findAll();
		}
		public List<Model> sortinfo(String s)
		{
			return br.findAll(Sort.by(Sort.DEFAULT_DIRECTION, s));
		}
		public List<Model> getbypage(int pagno,int pagsize)
		{
			Page<Model> p=br.findAll(PageRequest.of(pagno, pagsize));
			return p.getContent();
		}
		public List<Model> getpage(int pagno,int pagsize)
		{
			PageRequest pq=PageRequest.of(pagno, pagsize,Sort.by("lastname").descending());
			Page<Model> pm=br.findAll(pq);
			return pm.getContent();
		}

	
}
