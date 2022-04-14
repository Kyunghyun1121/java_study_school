interface Printer {
	public void print(Book b);
}

class SimpleBookPrinter implements Printer {

	@Override
	public void print(Book b) {
		System.out.println(b.getname() + "/" + b.getwriter() + "/" + b.getISBN());
	}

}

class PrettyBookPrinter implements Printer {
	@Override
	public void print(Book b) {
		System.out.println("***** Title : " + b.getname());
		System.out.println("***** Author: " + b.getwriter());
		System.out.println("***** ISBN: " + b.getISBN());
	}
}

class Book {
	private String name;
	private String ISBN;
	private String writer;
	private Printer myp;

	public Book(String n, String i, String w) {
		name = n;
		ISBN = i;
		writer = w;
	}

	public void setPrinter(Printer p) {
		myp = p;
	}

	public void print() {
		myp.print(this);
	}

	public String getname() {
		return name;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getwriter() {
		return writer;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("Java Book", "111-22-333333", "Jane Austin");
		System.out.println("첫번째 출력:");
		b1.setPrinter(new SimpleBookPrinter());
		b1.print();
		System.out.println("두번째 출력:");
		b1.setPrinter(new PrettyBookPrinter());
		b1.print();
	}

}