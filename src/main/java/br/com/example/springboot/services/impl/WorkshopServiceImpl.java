package br.com.example.springboot.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.example.springboot.models.Workshop;
import br.com.example.springboot.repository.WorkshopRepository;
import br.com.example.springboot.services.WorkshopService;

@Service
public class WorkshopServiceImpl implements WorkshopService{

	@Autowired
	private WorkshopRepository workshopRepository; 
	
	@Override
	public void addUpdate(Workshop workshop) {
		workshopRepository.save(workshop);
	}

	@Override
	public List<Workshop> getAll() {
//		manipulatingFiles();
		
		return (List<Workshop>) workshopRepository.findAll();
	}

	@Override
	public void deleteById(Long workshopId) {
		workshopRepository.delete(workshopId);
	}

	@Override
	public void deleteAll() {
		workshopRepository.deleteAll();
	}
	
	private void manipulatingFiles(MultipartFile multipartFile) throws IOException {
		String filesUploadedFolderPath = System.getProperty("user.dir") +"/"+ "filesUploaded";
		
		File dir = new File(filesUploadedFolderPath);
		File fileToRemove = new File(filesUploadedFolderPath +"/"+ "apagar.jpg");
		
		// deletando 
		if(!fileToRemove.isDirectory() && fileToRemove.exists()){
			if(fileToRemove.delete()){
				System.out.println("File deleted");
			}else{
				System.out.println("File not deleted");
			}
		}
		
		// listando arquivos
		if(dir.isDirectory()){
			for(int index = 0 ; index < dir.listFiles().length ; index++){
				File file = dir.listFiles()[index];
				System.out.println(file.getName());
			}
		}
		
		//extraindo file de uma multpartFile
		File fileExtracted = new File(multipartFile.getOriginalFilename());
		fileExtracted.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(fileExtracted);
		fileOutputStream.write(multipartFile.getBytes());
		fileOutputStream.close();
		
		//deletando pasta da page
		if(dir.isDirectory()){
			dir.delete();
		}
	}
}