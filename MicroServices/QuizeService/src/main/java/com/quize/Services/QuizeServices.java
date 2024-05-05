package com.quize.Services;

import java.util.List;
import java.util.Optional;

import com.quize.Entity.Quize;

public interface QuizeServices {
	
	Quize add(Quize quize);
	
	List<Quize> get();
	
	Quize get(Long id);
	

}
