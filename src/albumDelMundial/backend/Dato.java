package albumDelMundial.backend;

import java.util.Date;


public class Dato{
		private int id;
		private int participante;
		private int cantPaquetes;
		private Date fecha;
		

		public Dato() {
		}
		
		public Dato(Date fecha) {
			this.fecha = fecha;
		}

		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getParticipante() {
			return participante;
		}


		public void setParticipante(int participante) {
			this.participante = participante;
		}


		public int getCantPaquetes() {
			return cantPaquetes;
		}


		public void setCantPaquetes(int cantPaquetes) {
			this.cantPaquetes = cantPaquetes;
		}


		public Date getFecha() {
			return fecha;
		}


		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
}
