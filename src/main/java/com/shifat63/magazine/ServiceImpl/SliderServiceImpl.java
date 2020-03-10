package com.shifat63.magazine.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.shifat63.magazine.Model.Slider;
import com.shifat63.magazine.Repositories.SliderRepository;
import com.shifat63.magazine.Service.SliderService;

@Service
@Profile({"springdatajpa"})
public class SliderServiceImpl implements SliderService {
	private SliderRepository sliderRepository;
	
	public SliderServiceImpl(SliderRepository sliderRepository) {
		this.sliderRepository = sliderRepository;
	}
	
	@Override
	public Set<Slider> findAll() throws Exception {
		Set<Slider> SliderSet = new HashSet<>();
        sliderRepository.findAll().forEach(SliderSet::add);
        return SliderSet;
	}

	@Override
	public Slider findById(Integer id) throws Exception {
		return sliderRepository.findById(id).get();
	}

	@Override
	public Slider save(Slider object) throws Exception {
		return sliderRepository.save(object);
	}

	@Override
	public void delete(Slider object) throws Exception {
		sliderRepository.delete(object);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		sliderRepository.deleteById(id);;
		
	}

	@Override
	public void deleteAll() throws Exception {
		sliderRepository.deleteAll();
	}

}
