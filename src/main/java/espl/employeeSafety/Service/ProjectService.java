package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	Project getProjectById(int id);

	Project addProject(Project project);

	Project updateProject(int id, Project project);

	void deleteProject(int id);

}