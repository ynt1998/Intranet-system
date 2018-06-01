package main;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class Driver {
	public static void Serialize(String s, Object o) throws IOException {
		FileOutputStream fos = new FileOutputStream(s);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(o);
		oos.flush();
		oos.close();
	}
	
	public static void Update(String s) throws IOException, ClassNotFoundException {
		FileInputStream fit = new FileInputStream("teachers.txt");
		ObjectInputStream oit = new ObjectInputStream(fit);
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		teachers = (ArrayList<Teacher>) oit.readObject();
		FileInputStream fic = new FileInputStream("courses.txt");
		ObjectInputStream oic = new ObjectInputStream(fic);
		ArrayList<Course> courses = new ArrayList<Course>();
		courses = (ArrayList<Course>) oic.readObject();
		FileInputStream fis = new FileInputStream("students.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Student> students = new ArrayList<Student>();
		students = (ArrayList<Student>) ois.readObject();
		if (s.equals("Teachers")) System.out.println(teachers);
		if (s.equals("Students")) System.out.println(students);
		if (s.equals("Courses")) System.out.println(courses);
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, ParseException {
		Scanner in = new Scanner(System.in);
		FileInputStream fis = new FileInputStream("students.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Student> students = new ArrayList<Student>();
		students = (ArrayList<Student>) ois.readObject();
		FileInputStream fit = new FileInputStream("teachers.txt");
		ObjectInputStream oit = new ObjectInputStream(fit);
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		teachers = (ArrayList<Teacher>) oit.readObject();
		FileInputStream fic = new FileInputStream("courses.txt");
		ObjectInputStream oic = new ObjectInputStream(fic);
		ArrayList<Course> courses = new ArrayList<Course>();
		courses = (ArrayList<Course>) oic.readObject();
//		FileInputStream fif = new FileInputStream("coursefiles.txt");
//		ObjectInputStream oif = new ObjectInputStream(fif);
		HashMap<String,String> cfiles = new HashMap<String,String>();
//		cfiles = (HashMap<String,String>) oic.readObject();
		FileInputStream fin = new FileInputStream("news.txt");
		ObjectInputStream oin = new ObjectInputStream(fin);
		ArrayList<News> news = new ArrayList<News>();
		news = (ArrayList<News>) oin.readObject();
		menu: while (true) {
			System.out.println("Hello! Ask yourself 'Who am I?'");
			System.out.println("\n  Student \n  Teacher  \n  Admin \n  Guest \n  Manager \n  Executor");
			String choice = in.nextLine();
			if (choice.equals("Student")) {
				student: while (true) {
					System.out.println("Enter a password and name or if you want to exit write 'exit'");
					choice = in.nextLine();
					Iterator it = students.iterator();
					while (it.hasNext()) {
						Student st = (Student) it.next();
						if (choice.equals(st.getUsername())) {
							choice = in.nextLine();
							if (choice.equals(st.getPassword())) {
								
								nov: while (true) {
									System.out.println(
											"What do you want to do?\n Download files\n View attendance\n View marks\n View files\n Register course\n Update\n Change password\n Add comment\n");
									choice = in.nextLine();
									if (choice.equals("Download")) {
										String name = in.nextLine();//teacher name
										Iterator iterator = teachers.iterator();
										
											for (String material : (cfiles.keySet())) {
													System.out.println(material);
												}
											try {
												// ךאקאול פאיכ ס ןמלמשü‏ NIO
												Student.downloadUsingNIO(cfiles.get(in.nextLine()), "C:\\Users\\PC\\Desktop\\Student\\lab.txt");
											} catch (IOException e) {
												e.printStackTrace();
											}
											
										
									} else if (choice.equals("View attendance")) {
										st.viewAttendance(st.getUsername());
										Thread.sleep(3000);
									} else if (choice.equals("View transcript")) {
										st.viewMark(st.getUsername());
										
									} 
									else if(choice.equals("Update")) {
										System.out.println("Choose what do u want to update?\n Teachers\n Students\n Courses");
										String s=in.nextLine();
										Update(s);
									}
									else if (choice.equals("Register")) {
										Iterator c = courses.iterator();
										while(c.hasNext()){
											Course course =(Course)c.next();
											if(course.getFaculty().equals(st.getFaculty()) && course.getYear()==(st.getYearOfStudy())){
												
												Date firstDate = new Date(117,10,20,23,59,59);
												Date secondDate = new Date(117,10,30,23,59,59);
//												DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
												Date date = new Date();
												if(date.before(secondDate) && date.after(firstDate)){
													System.out.println(course.getName());
												}
											}
										}
										st.setCourse(in.nextLine());
										Serialize("student.txt",students);
										System.out.println("You successfully registered all courses.");
										Thread.sleep(3000);
									}else if(choice.equals("Change")){
										st.setPassword(in.nextLine());
										
										
										System.out.println("Password changed");
										Thread.sleep(2000);
									}
									else if(choice.equals("Add comment")){
										Iterator view = news.iterator();
										while (view.hasNext()) {
											News nview = (News) view.next();
											System.out.println(nview.getTitle());
											System.out.println(nview.getContent());
											System.out.println(nview.getAuthor());
											System.out.println(nview.comment);
										}
										System.out.println("Type title of news you want to add comment");

										Iterator it2 = news.iterator();
										String title = in.nextLine();

										while (it2.hasNext()) {
											News n = (News) it2.next();
											if (title.equals(n.getTitle())) {
												System.out.println(n.getContent());
												n.comment.add(st.getUsername()+":"+in.nextLine());
												Serialize("news.txt", news);
											}

										}
										
									}
									else if (choice.equals("exit")) {
										continue menu;
									} else {
										continue nov;
									}
								}
							}
						} else if (choice.equals("exit")) {
							continue menu;
						} else {
							continue;
						}

					}

					break;
				}
			} else if (choice.equals("Teacher")) {
				teacher: while (true) {
					System.out.println("Enter a password and name or if you want to exit write 'exit'");
					choice = in.nextLine();
					Iterator it = teachers.iterator();
					while (it.hasNext()) {
						Teacher tr = (Teacher) it.next();
						if (choice.equals(tr.getUsername())) {
							choice = in.nextLine();
							if (choice.equals(tr.getPassword())) {
								nov: while (true) {
									System.out.println(
											"What do you want to do?\n Upload  files\n View files\n Update\n Put attendance\n Put a mark\n View courses \n Send order\n View accepted/rejected orders \n Change password\n Add comment\n");
									choice = in.nextLine();
									if (choice.equals("Upload")) {
										cfiles.put(tr.getUsername()+"*"+in.nextLine(), in.nextLine());
										Serialize("coursefiles.txt",cfiles);
									} else if (choice.equals("View")) {
										tr.showCourseFile(tr.getName());
									} else if (choice.equals("Put attendance")) {
										Iterator st = students.iterator();
										while (st.hasNext()) {
											Student s = (Student) st.next();
											System.out.println(s.getUsername());
										}
										String sn = in.nextLine();
										while (!sn.isEmpty()) {
											tr.putAttendance(tr.getUsername(), sn, in.nextLine(), in.nextLine());
											sn = in.nextLine();
										}
										

									}
									else if (choice.equals("View courses")) {
										Iterator view = courses.iterator();
										while (view.hasNext()) {
											Course nview = (Course) view.next();
											System.out.println(nview.getName());
											System.out.println(nview.getFaculty());
											System.out.println(nview.getCredit());
										}
										

									}
									else if(choice.equals("Update")) {
										System.out.println("Choose what do u want to update? Teachers\n Students\n Courses");
										String s=in.nextLine();
										Update(s);
									}
									else if(choice.equals("Add comment")){
										Iterator view = news.iterator();
										while (view.hasNext()) {
											News nview = (News) view.next();
											System.out.println(nview.getTitle());
											System.out.println(nview.getContent());
											System.out.println(nview.getAuthor());
											System.out.println(nview.comment);
										}
										System.out.println("Type title of news you want to add comment");

										Iterator it2 = news.iterator();
										String title = in.nextLine();

										while (it2.hasNext()) {
											News n = (News) it2.next();
											if (title.equals(n.getTitle())) {
												System.out.println(n.getContent());
												n.comment.add(tr.getUsername()+":"+in.nextLine());
												Serialize("news.txt", news);
											}

										}
										
									}
									else if (choice.equals("Put mark")) {
										String line;
										line = tr.getCourses();
										StringTokenizer tokenizer = new StringTokenizer(line, "*");
										while(tokenizer.hasMoreTokens()){
											System.out.println(tokenizer.nextToken());
										}
										line = in.nextLine();//type course
										Iterator st = students.iterator();
										while (st.hasNext()) {
											Student s = (Student) st.next();
											StringTokenizer tokenizer1 = new StringTokenizer(s.getCourse(), "*");
											while(tokenizer1.hasMoreElements()){
												if(tokenizer1.nextToken().equals(line)){
													System.out.println(s.getUsername());
												}
											}
											
										}
										String sn = in.nextLine();
										while (!sn.isEmpty()) {
											tr.putMark(line, sn,Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()),Integer.parseInt(in.nextLine()));
											sn = in.nextLine();
										}

									} else if (choice.equals("Order")) {
										System.out.println(
												"Please enter with its subject, like Subject is:... Order is:  ");
										String order = in.nextLine();
										tr.sendOrder(order);
									}
									else if (choice.equals("AcceptedOrders")) { 
										Executor e=new Executor();
										e.viewAcceptedorders(); 

										} 
										else if (choice.equals("RejectedOrders")) { 
										Executor e=new Executor();
										e.viewRejectedorders(); 

										}else if(choice.equals("Change")){
										tr.setPassword(in.nextLine());
										System.out.println("Password changed");
										Thread.sleep(2000);
									}else if (choice.equals("exit")) {
										continue menu;
									} else {
										continue nov;
									}
								}
							}
						} else if (choice.equals("exit")) {
							continue menu;
						} 
					}

					break;
				}
			} else if (choice.equals("Admin")) {
				while (true) {
					System.out.println("Enter a password and name or if you want to exit write 'exit'");
					choice = in.nextLine();
					String name = " ";
					name = Files.readAllLines(Paths.get("op.txt")).get(2);
					String pass = Files.readAllLines(Paths.get("op.txt")).get(3);

					if (choice.equals(name)) {
						choice = in.nextLine();
						if (choice.hashCode() == Integer.parseInt(pass)) {
							while (true) {
								System.out
										.println("What do you want to do?\n Add/Delete student\n Add/Delete teacher\n "
												+ "Add news\n Add/Delete subject\n ");
								choice = in.nextLine();
								Admin a = new Admin();
								if (choice.equals("Add student")) {
									String sname = in.nextLine();
									while (!(sname).isEmpty()) {
										int id = Integer.parseInt(in.nextLine());
										int year = Integer.parseInt(in.nextLine());
										students.add(a.addStudents(sname, id, year,in.nextLine()));
										sname = in.nextLine();
									}
									Serialize("students.txt", students);

									System.out.println("You successfully added a student.");
									Thread.sleep(3000);
								} else if (choice.equals("Remove student")) {
									System.out.println(students);
									Iterator it = students.iterator();
									String s = in.nextLine();
									while (it.hasNext()) {
										Student st = (Student) it.next();
										if (s.equals(st.name)) {
											it.remove();
										}
									}
									Serialize("students.txt",students);

									System.out.println("You successfully deleted a student.");
									Thread.sleep(3000);
								} else if (choice.equals("Add teacher")) {
									Iterator it = courses.iterator();
									while(it.hasNext()){
										System.out.println(((Course)it.next()).getName());
									}
									String tname = in.nextLine();
									while (!tname.isEmpty()) {
										int salary = Integer.parseInt(in.nextLine());
										int id = Integer.parseInt(in.nextLine());
										int year = Integer.parseInt(in.nextLine());
										teachers.add(a.addTeachers(tname, id, salary,year,in.nextLine()));
										tname = in.nextLine();
									}

									Serialize("teachers.txt", teachers);
									System.out.println("You successfully added a teacher.");
									Thread.sleep(3000);
								}
								else if (choice.equals("Remove teacher")) {
									System.out.println(teachers);
									Iterator it = teachers.iterator();
									String tname = in.nextLine();
									while (it.hasNext()) {
										Teacher st = (Teacher) it.next();
										if (tname.equals(st.name)) {
											it.remove();
										}
									}
									Serialize("teachers.txt",teachers);
									System.out.println("You successfully removed a teacher.");
									Thread.sleep(3000);
								} 
								/*else if (choice.equals("Update teacher")) {
									a.updateTeacher();
									System.out.println("Enter name of teacher you want to update");
									Iterator it = teachers.iterator();
									String tname = in.nextLine();
									while (it.hasNext()) {
										Teacher st = (Teacher) it.next();
										if (tname.equals(st.name)) {
											it.remove();											
											System.out.println("Enter new salary,course and new year of this teacher");
											int salary = Integer.parseInt(in.nextLine());
											int year = Integer.parseInt(in.nextLine());
											String course=in.nextLine();
											teachers.add(a.addTeachers(tname, st.getId(), salary,year,course));
											
											
										}
									}
									Serialize("teachers.txt",teachers);
									System.out.println("You successfully updated a teacher.");
									Thread.sleep(3000);
								}
								else if (choice.equals("Update student")) {
									a.updateStudent();
									System.out.println("Enter name of student you want to update");
									Iterator it = students.iterator();
									String sname = in.nextLine();
									while (it.hasNext()) {
										Student s = (Student) it.next();
										if (sname.equals(s.name)) {
											it.remove();											
											System.out.println("Enter new studying faculty and new year of this student");
											String faculty = in.nextLine();
											int year = Integer.parseInt(in.nextLine());
											students.add(a.addStudents(sname, s.getId(), year, faculty));
											
											
											
											
										}
										
									}
									Serialize("students.txt",students);
									System.out.println("You successfully updated a student.");
									Thread.sleep(3000);
								}*/
								else if (choice.equals("Add news")) {
									String title = in.nextLine();
									while (!title.isEmpty()) {
										String content = in.nextLine();
										String text = "";
										while (!content.isEmpty()) {
											text = text + content;
											content = in.nextLine();
										}
										news.add(a.addNews(title, text, in.nextLine()));
										title = in.nextLine();
									}
									Serialize("news.txt", news);

									System.out.println("You successfully added news.");
									Thread.sleep(3000);
								} else if (choice.equals("Add subject")) {
									
									String c = in.nextLine();
									while (!c.isEmpty()) {
										courses.add(a.addCourse(c, in.nextLine(), Integer.parseInt(in.nextLine()),Integer.parseInt(in.nextLine())));
										c = in.nextLine();
									}
									Serialize("courses.txt", courses);
									System.out.println("You successfully added a course.");
									Thread.sleep(3000);
								} else if (choice.equals("Remove subject")) {
									System.out.println(courses);
									Iterator it = courses.iterator();
									String s = in.nextLine();
									while (it.hasNext()) {
										Course st = (Course) it.next();
										if (s.equals(st.getName())) {
											it.remove();
										}
									}
									Serialize("courses.txt",courses);
									System.out.println("You successfully removed a subject.");
									Thread.sleep(3000);
								} else if (choice.equals("exit")) {
									continue menu;
								}
							}
						}

					} else if (choice.equals("exit")) {
						continue menu;
					}

					break;
				}
			} else if (choice.equals("Manager")) {
				manager: while (true) {
					System.out.println("Enter a password and name or if you want to exit write 'exit'");
					choice = in.nextLine();
					String name = " ";
					name = Files.readAllLines(Paths.get("op.txt")).get(4);
					String pass = Files.readAllLines(Paths.get("op.txt")).get(5);

					if (choice.equals(name)) {
						choice = in.nextLine();
						if (choice.hashCode() == Integer.parseInt(pass)) {
						nov: while (true) {
							Manager m = new Manager();
							System.out.println("What do you want? Check comments \n Create report \n Update\n");
							choice = in.nextLine();
							if (choice.equals("Check comments")) {

								for(int i=0; i<news.size(); i++) { 
									System.out.println(news.get(i).getTitle()); 
									System.out.println(news.get(i).getContent()); 
									System.out.println(news.get(i).comment); 
									System.out.println("---------------------------------"); 
									} 
									System.out.println("Enter the title, then the number of comment that you want to delete"); 
									String title = in.nextLine(); 
									int numb=Integer.parseInt(in.nextLine()); 

									for(int i=0; i<news.size(); i++) { 
									if(title.equals(news.get(i).getTitle())) { 
									System.out.println(news.get(i).comment); 
									System.out.println("Deleted comment is "+ news.get(i).comment.remove(numb-1)); 
									Serialize("news.txt",news); 
									break; 
									} 
									} 
							}
							else if(choice.equals("Update")) {
								System.out.println("Choose what do u want to update? Teachers\n Students\n Courses");
								String s=in.nextLine();
								Update(s);
							}

							else if (choice.equals("Create report")) {
								System.out.println(teachers);
								System.out.println("Enter name of teacher and your report text");
								String teacher = in.nextLine();
								String report = in.nextLine();
								m.createReport(teacher, report);
							} else {
								continue nov;
							}
							break;
						}
						}	

					} else if (choice.equals("exit")) {
						continue menu;
					} else {
						continue manager;
					}
					break;
				}
			} else if (choice.equals("Executor")) {
				executor: while (true) {
					System.out.println("Enter a password and name or if you want to exit write 'exit'");
					choice = in.nextLine();
					String name = " ";
					name = Files.readAllLines(Paths.get("op.txt")).get(0);
					String pass = Files.readAllLines(Paths.get("op.txt")).get(1);

					if (choice.equals(name)) {
						choice = in.nextLine();
						if (choice.hashCode() == Integer.parseInt(pass)) 
							nov: while (true) {
								Executor e = new Executor();
								System.out.println(
										"Do you want to view new orders or accepted/rejected orders? type Orders, AcceptedOrders or RejectedOrders \n Update");
								choice = in.nextLine();
								if (choice.equals("Orders")) { 
									e.viewOrders(); 
									System.out.println("Enter subject of order you want to accept or reject"); 
									String suborder = in.nextLine(); 
									System.out.println("Do you want to accept or reject it?"); 
									String acrej = in.nextLine(); 
									if (acrej.equals("Accept")) { 
									Map<Date, String> acceptedorders = new HashMap<Date, String>(); 
									FileOutputStream fos = new FileOutputStream("acceptedorders.txt"); 
									ObjectOutputStream oos = new ObjectOutputStream(fos); 
									DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
									Calendar cal = Calendar.getInstance(); 
									acceptedorders.put(cal.getTime(), suborder); 
									oos.writeObject(acceptedorders); 
									oos.flush(); 
									oos.close(); 
									} 
									if (acrej.equals("Reject")) { 
									Map<Date, String> rejectedorders = new HashMap<Date, String>(); 
									FileOutputStream fos = new FileOutputStream("rejectedorders.txt");
									ObjectOutputStream oos = new ObjectOutputStream(fos); 
									DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
									Calendar cal = Calendar.getInstance(); 
									rejectedorders.put(cal.getTime(), suborder); 
									oos.writeObject(rejectedorders); 
									oos.flush(); 
									oos.close(); 
									} 
									}
								else if(choice.equals("Update")) {
									System.out.println("Choose what do u want to update? Teachers\n Students\n Courses");
									String s=in.nextLine();
									Update(s);
								}
									else if (choice.equals("AcceptedOrders")) { 
									e.viewAcceptedorders(); 

									} 
									else if (choice.equals("RejectedOrders")) { 
									e.viewRejectedorders(); 

									} else {
									continue nov;
								}
							}

					} else if (choice.equals("exit")) {
						continue menu;
					} else {
						continue executor;
					}

					break;
				}
			} else if (choice.equals("Guest")) {
				Iterator view = news.iterator();
				while (view.hasNext()) {
					News nview = (News) view.next();
					System.out.println(nview.getTitle());
					System.out.println(nview.getContent());
					System.out.println(nview.getAuthor());
					System.out.println(nview.comment); 
				}

				Iterator it = news.iterator();
				String title = in.nextLine();

				while (it.hasNext()) {
					News n = (News) it.next();
					if (title.equals(n.getTitle())) {
						System.out.println(n.getContent());
						n.comment.add(in.nextLine());
						Serialize("news.txt", news);
					}

				}
				
				continue menu;
			} else {
				System.exit(0);
			}
		}
	}
}
