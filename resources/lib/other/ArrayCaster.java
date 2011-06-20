package resources.lib.other;

import resources.lib.domain.Candidato;
import resources.lib.domain.Partido;

public class ArrayCaster {
	public static Integer[] objectCastInteger(Object[] obj) {
		Integer[] intobj = new Integer[obj.length];
		for(int i = 0; i < obj.length; i++) {
			intobj[i] = (Integer) obj[i];
		}
		return intobj;
	}
	
	public static String[] objectCastString(Object[] obj) {
		String[] intobj = new String[obj.length];
		for(int i = 0; i < obj.length; i++) {
			intobj[i] = (String) obj[i];
		}
		return intobj;
	}
	
	public static Candidato[] objectCastCandidato(Object[] obj) {
		Candidato[] intobj = new Candidato[obj.length];
		for(int i = 0; i < obj.length; i++) {
			intobj[i] = (Candidato) obj[i];
		}
		return intobj;
	}
	
	public static Partido[] objectCastPartido(Object[] obj) {
		Partido[] intobj = new Partido[obj.length];
		for(int i = 0; i < obj.length; i++) {
			intobj[i] = (Partido) obj[i];
		}
		return intobj;
	}
}
