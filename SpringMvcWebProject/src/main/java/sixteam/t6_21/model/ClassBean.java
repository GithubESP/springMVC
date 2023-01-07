package sixteam.t6_21.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "class")
@Component
public class ClassBean {
	@Id
	@Column(name = "classId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	@Column(name = "className")
	private String className;
	@Column(name = "classTeacherName")
	private String classTeacherName;
//	@Column(name = "classPrice")
//	private Double classPrice;
	@Column(name = "classPictureName")
	private String classPictureName;
	@Column(name = "classPicture1")
	private byte[] classPicture1;
//	@Column(name = "classTeacherPicture")
//	private byte[] classTeacherPicture;
//	@Column(name = "classType")
//	private String classType;
//	@Column(name = "classDate")
//	private Date classDate;
//	@Column(name = "classAddress")
//	private String classAddress;
//	@Column(name = "classPeople")
//	private int classPeople;

	public ClassBean(String className, String classTeacherName, byte[] classPicture1) {
		this.className = className;
		this.classTeacherName = classTeacherName;
		this.classPicture1 = classPicture1;
	}

	public ClassBean() {
	}
	
	
	
	public ClassBean(int classId, String className, String classTeacherName, String classPictureName,
			byte[] classPicture1) {
		this.classId = classId;
		this.className = className;
		this.classTeacherName = classTeacherName;
		this.classPictureName = classPictureName;
		this.classPicture1 = classPicture1;
	}

	public ClassBean(String className, byte[] classPicture1, String classPictureName, String classTeacherName) {
		super();
		this.className = className;
		this.classTeacherName = classTeacherName;
		this.classPictureName = classPictureName;
		this.classPicture1 = classPicture1;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassTeacherName() {
		return classTeacherName;
	}

	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
	}

//	public Double getClassPrice() {
//		return classPrice;
//	}
//
//	public void setClassPrice(Double classPrice) {
//		this.classPrice = classPrice;
//	}

	public byte[] getClassPicture1() {
		return classPicture1;
	}

	public void setClassPicture1(byte[] classPicture1) {
		this.classPicture1 = classPicture1;
	}

//	public byte[] getClassTeacherPicture() {
//		return classTeacherPicture;
//	}
//
//	public void setClassTeacherPicture(byte[] classTeacherPicture) {
//		this.classTeacherPicture = classTeacherPicture;
//	}
//
//	public String getClassType() {
//		return classType;
//	}
//
//	public void setClassType(String classType) {
//		this.classType = classType;
//	}
//
//	public Date getClassDate() {
//		return classDate;
//	}
//
//	public void setClassDate(Date classDate) {
//		this.classDate = classDate;
//	}
//
//	public String getClassAddress() {
//		return classAddress;
//	}
//
//	public void setClassAddress(String classAddress) {
//		this.classAddress = classAddress;
//	}
//
//	public int getClassPeople() {
//		return classPeople;
//	}
//
//	public void setClassPeople(int classPeople) {
//		this.classPeople = classPeople;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClassBean [classId=");
		builder.append(classId);
		builder.append(", className=");
		builder.append(className);
		builder.append(", classTeacherName=");
		builder.append(classTeacherName);
//		builder.append(", classPrice=");
//		builder.append(classPrice);
		builder.append(", classPictureName=");
		builder.append(classPictureName);
//		builder.append(", classPicture1=");
//		builder.append(Arrays.toString(classPicture1));
//		builder.append(", classTeacherPicture=");
//		builder.append(Arrays.toString(classTeacherPicture));
//		builder.append(", classType=");
//		builder.append(classType);
//		builder.append(", classDate=");
//		builder.append(classDate);
//		builder.append(", classAddress=");
//		builder.append(classAddress);
//		builder.append(", classPeople=");
//		builder.append(classPeople);
		builder.append("]");
		return builder.toString();
	}

	public String getClassPictureName() {
		return classPictureName;
	}

	public void setClassPictureName(String classPictureName) {
		this.classPictureName = classPictureName;
	}

}
