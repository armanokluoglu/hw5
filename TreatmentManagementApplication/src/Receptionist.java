import java.util.ArrayList;
import java.util.List;

public class Receptionist {
	private Hospital hospital;
	private String fullName;
	private List<Appointment<Patient, Doctor>> schedule;
	
	public Receptionist(Hospital hospital, String fullName) {
		setHospital(hospital);
		setFullName(fullName);
		schedule = new ArrayList<Appointment<Patient, Doctor>>();
	}
	
	public void registerAPatient(Doctor doctor, Patient patient, Date appointmentDate) {
		Appointment<Patient, Doctor> appointment = new Appointment<Patient, Doctor>(patient, doctor, appointmentDate);
		patient.setAppointment(appointment);
		getHospital().addPatient(patient);
		schedule.add(appointment);
	}
	
	public List<Appointment<Patient, Doctor>> getAppointmentsOfDate(Date date){
		List<Appointment<Patient, Doctor>> todaysSchedule = new ArrayList<Appointment<Patient, Doctor>>();
		for(Appointment<Patient, Doctor> appointment: getSchedule()) {
			if(appointment.getAppointmentDate().equals(date)){
				todaysSchedule.add(appointment);
			}
		}
		return todaysSchedule;
	}
	
	public SurgeryAppointment getSurgeryAppointmentForSurgeon(Surgeon surgeon) {
		SurgeryAppointment surgeryAppointment = new SurgeryAppointment();
		for(Appointment<Patient, Doctor> appointment: getSchedule()) {
			if(appointment.getDoctor().equals(surgeon) && appointment.getClass().equals(surgeryAppointment.getClass())){
				surgeryAppointment = (SurgeryAppointment) appointment;
			}
		}
		return surgeryAppointment;
	}
	
	public List<Appointment<Patient, Doctor>> getSchedule()	{return schedule;}
	
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public String getFullName() {
		return fullName;
	}
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
}