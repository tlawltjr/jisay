package utilex;
/*
 * 자바의 record 는 DTO 와 유사한 개념으로 초기화를 생성자를 통해 합니다.
 * 따라서 초기화 필드값을 생성자에 넣어주시면, 자동으로 해당 객체가 초기화 되고
 * 자동으로 getter, toString, hashCode(), equals() 메서드를 생성해 줍니다.
 * 참고로 자동으로 getter 가 생성되어도 호출을 할 때는, getXXX() 가 아니라
 * record.fieldName() 으로 호출해야 합니다.
 */
public record Member(String id, String name, int age) {

}
