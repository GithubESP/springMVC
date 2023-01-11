package sixteam.t6_14.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Component
@Data
@Entity
@Table(name = "templeactive")
public class Actives {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activeid")
	private Integer activeID;
	@Column(name = "activename")
	private String activeName;
	@Column(name = "activeimg")
	private byte[] activeImg;
	@Column(name = "activedescription")
	private String activedescription;
	@Column(name = "activestartdate")
	private Date activeStartDate;
	@Column(name = "activeenddate")
	private Date activeEndDate;
	@Column(name = "activelocation")
	private String activeLocation;
	@Column(name = "activehost")
	private String activeHost;
	




	public Actives(Integer activeID, String activeName, byte[] activeImg, String activeDescription,
			Date activeStartDate, Date activeEndDate, String activeLocation, String activeHost) {
		super();
		this.activeID = activeID;
		this.activeName = activeName;
		this.activeImg = activeImg;
		this.activedescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}





	





	
	
	public Integer getActiveID() {
		return activeID;
	}













	public void setActiveID(Integer activeID) {
		this.activeID = activeID;
	}













	public String getActiveName() {
		return activeName;
	}













	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}













	public byte[] getActiveImg() {
		return activeImg;
	}













	public void setActiveImg(byte[] activeImg) {
		this.activeImg = activeImg;
	}













	public String getActivedescription() {
		return activedescription;
	}













	public void setActivedescription(String activedescription) {
		this.activedescription = activedescription;
	}













	public Date getActiveStartDate() {
		return activeStartDate;
	}













	public void setActiveStartDate(Date activeStartDate) {
		this.activeStartDate = activeStartDate;
	}













	public Date getActiveEndDate() {
		return activeEndDate;
	}













	public void setActiveEndDate(Date activeEndDate) {
		this.activeEndDate = activeEndDate;
	}













	public String getActiveLocation() {
		return activeLocation;
	}













	public void setActiveLocation(String activeLocation) {
		this.activeLocation = activeLocation;
	}













	public String getActiveHost() {
		return activeHost;
	}













	public void setActiveHost(String activeHost) {
		this.activeHost = activeHost;
	}













	public Actives(String activeName, byte[] activeImg, String activeDescription, Date activeStartDate,
			Date activeEndDate, String activeLocation, String activeHost) {
		super();
		this.activeName = activeName;
		this.activeImg = activeImg;
		this.activedescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}



	public Actives(String activeName, String activeDescription, Date activeStartDate, Date activeEndDate,
			String activeLocation, String activeHost) {
		super();
		this.activeName = activeName;
		this.activedescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}

	

	public Actives(Integer activeID, String activeName, String activeDescription, Date activeStartDate,
			Date activeEndDate, String activeLocation, String activeHost) {
		super();
		this.activeID = activeID;
		this.activeName = activeName;
		this.activedescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}


	public Actives() {
	}

}
