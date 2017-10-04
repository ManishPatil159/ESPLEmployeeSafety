package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.Project;
import espl.employeeSafety.Repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.ProjectService#getAllProjects()
	 */
	@Override
	public Page<Project> getAllProjects(Pageable pageable){
		return projectRepository.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.ProjectService#getProjectById(int)
	 */
	@Override
	public Project getProjectById(int id) {
		return projectRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.ProjectService#addProject(espl.employeeSafety.Entity.Project)
	 */
	@Override
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.ProjectService#updateProject(int, espl.employeeSafety.Entity.Project)
	 */
	@Override
	public Project updateProject(int id, Project project) {
		Project repoProject=getProjectById(id);
		if(repoProject!=null) {
			repoProject.setProjectName(project.getProjectName());
			return projectRepository.save(repoProject);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.ProjectService#deleteProject(int)
	 */
	@Override
	public void deleteProject(int id) {
		projectRepository.delete(id);
	}

	
}
