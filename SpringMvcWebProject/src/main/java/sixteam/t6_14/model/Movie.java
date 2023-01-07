package sixteam.t6_14.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Table(name = "movie")
public class Movie {
	@Id@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String country;
	private String name;
	private Date releaseDate;
	private String applicant;
	private String company;
	private int showingNums;
	private int salesTicketNum;
	private int sales;
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [id=").append(id).append(", country=").append(country).append(", name=").append(name)
				.append(", releaseDate=").append(releaseDate).append(", applicant=").append(applicant).append(", company=")
				.append(company).append(", showingNums=").append(showingNums).append(", salesTicketNum=")
				.append(salesTicketNum).append(", sales=").append(sales).append("]");
		return builder.toString();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDate() {
		return releaseDate;
	}



	public void setDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	public String getApplicant() {
		return applicant;
	}



	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public int getShowingNums() {
		return showingNums;
	}



	public void setShowingNums(int showingNums) {
		this.showingNums = showingNums;
	}



	public int getSalesTicketNum() {
		return salesTicketNum;
	}



	public void setSalesTicketNum(int salesTicketNum) {
		this.salesTicketNum = salesTicketNum;
	}



	public int getSales() {
		return sales;
	}



	public void setSales(int sales) {
		this.sales = sales;
	}



	public Movie(int id, String country, String name, Date releaseDate, String applicant, String company, int showingNums,
			int salesTicketNum, int sales) {
		super();
		this.id = id;
		this.country = country;
		this.name = name;
		this.releaseDate = releaseDate;
		this.applicant = applicant;
		this.company = company;
		this.showingNums = showingNums;
		this.salesTicketNum = salesTicketNum;
		this.sales = sales;
	}



	public Movie() {
	}

}
