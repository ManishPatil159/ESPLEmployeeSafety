package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.Sos;

public interface SosService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#getAllSoss()
	 */
	public abstract List<Sos> getAllSoss();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#getSosById(int)
	 */
	public abstract Sos getSosById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#addSos(espl.employeeSafety.Entity.Sos)
	 */
	public abstract Sos addSos(Sos sos);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#updateSos(int, espl.employeeSafety.Entity.Sos)
	 */
	public abstract Sos updateSos(int id, Sos sos);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#deleteSos(int)
	 */
	public abstract void deleteSos(int id);

}