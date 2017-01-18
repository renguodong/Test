package cn.rgd.demo;

import java.io.Serializable;

@SuppressWarnings("serial")
class Book implements Serializable {
	private String name;
	private int age;
	public Book() {}
	public Book(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return this.name +","+ this.age;
	}
}
//public class Demo {
//	public static void main(String[] args) throws Exception {
//		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("E:"+ File.separator +"Test"+ File.separator +"Test.txt")));
//		os.writeObject(new Book("JAVA", 12));
//		os.close();
//		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File("E:"+ File.separator +"Test"+ File.separator +"Test.txt")));
//		Object obj = oi.readObject();
//		oi.close();
//		System.out.println(obj);
//	}
//}
