package dataClass;

public class PostForComplexObject {

	 private String id;
	 private String title;
	 private String author;
	 private Info post;
	 private Info[] postArray;
	 
	 
	 public void setID(String id) {
		 this.id = id;
	 }

	 public void setTitle(String title) {
		 this.title = title;
	 }
	 
	 public void setAuthor(String author) {
		 this.author = author;
	 }
	 
	 public String getID() {
		 return id;
	 } 
	 
	 public String getAuthor() {
		 return author;
	 } 
	 
	 public String getTitle() {
		 return title;
	 } 
	 
	 /*public Info getInfo() {
		 return this.post;
	 }*/
	 
	 public void setInfo(Info post) {
		 this.post = post;
	 }
	 
	 
	 public Info[] getInfo() {
		 return this.postArray;
	 }
	 
	 public void setInfo(Info[] postArray) {
		 this.postArray = postArray;
	 }
}
