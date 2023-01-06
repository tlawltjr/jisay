package utilex;
/*
 * DTO 는 자바 계열에서 사용되는 널리 알려진 객체 형태입니다.
 * Data Transfer Object 의 약자로, 이 객체는 자바의 기본 객체 형태를 취하며
 * 사용 목적은 이 객체에 연관되는 데이터를 생성후 이 데이터가 필요한 곳으로 객체를 보내는 것입니다.
 * 이렇게 보내진 DTO 를 받는 쪽에서는 getter 를 이용해서 속성의 값을 즉 필요로 하는 값을
 * 취하여 로직에 사용합니다. 보통 이 DTO 를 받는애를 DAO 라고 합니다. 즉 Data Access Object
 * 이는 나중에 다시 배울겁니다.
 * 
 * POJO : Plain Object Java Object
 */
public class StudentDTO {

	//참고로 DTO 의 모든 속성은 private 입니다.
	//번호
	private int number;
	private String name;
	private String tel;
	private int group;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	
	
	
	
}
