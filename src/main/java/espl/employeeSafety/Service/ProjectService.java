package espl.employeeSafety.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import espl.employeeSafety.Entity.Project;

public interface ProjectService {

	Page<Project> getAllProjects(Pageable pageable);

	Project getProjectById(int id);

	Project addProject(Project project);

	Project updateProject(int id, Project project);

	void deleteProject(int id);

	//Page<Project> getAllProjects(Pageable pageable);

}