package tutoringWebsite.persist;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import tutoringWebsite.model.*;

public class InitialData {
	public static List<Announcement> getAnnouncement() throws IOException {
		List<Announcement> announcementList = new ArrayList<Announcement>();
		ReadCSV readAnnouncement = new ReadCSV("Announcements.csv");
		try {
			// auto-generated primary key for authors table
			Integer announcementId = 1;
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			Integer announcementType = 1;
			Integer typeId = 1;
			while (true) {
				List<String> tuple = readAnnouncement.next();
				if(tuple==null || tuple.size() == 0) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Announcement announcement = new Announcement();
				announcement.setAnnouncementId(announcementId++);
				announcement.setMessage(i.next()); 
				date = LocalDate.parse(i.next());
				announcement.setDate(date);
				time = LocalTime.parse(i.next());
				announcement.setTime(time);
				announcementType = Integer.decode(i.next());
				announcement.setAnnouncementType(announcementType);
				typeId = Integer.decode(i.next());
				announcement.setTypeId(typeId);
				announcementList.add(announcement);
			}
			return announcementList;
		} finally {
				readAnnouncement.close();
			}
		}
	
	public static List<User> getUser() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUser = new ReadCSV("Users.csv");
		try {
			// auto-generated primary key for authors table
			Integer userId = 1;
			Integer userType = 1;
			String temp = "1";
			
			while (true) {
			List<String> tuple = readUser.next();
			if (tuple == null) {
				break;
			}
			Iterator<String> i = tuple.iterator();
			User user = new User();
			user.setUser_Id(userId++);
			user.setEmail(i.next());
			user.setPassword(i.next());
			user.setName(i.next());
			userType = Integer.decode(i.next());
			user.setUserType(userType);
			userList.add(user);
		}
			return userList;
		} finally {
				readUser.close();
			}
		}

	public static List<Session> getSession() throws IOException {
		List<Session> sessionList = new ArrayList<Session>();
		ReadCSV readSession = new ReadCSV("Sessions.csv");
		try {

			//System.out.println("In InitialData, getSession()...");

			

			Integer sessionId = 1;
			while(true) {

				List<String> tuple = readSession.next();
				if(tuple==null || tuple.size() == 0) {
					break;
				}
			
				Iterator<String> i = tuple.iterator();
				Session session = new Session();
				session.setSessionId(sessionId++);

				//System.out.println("Session ID: " + session.getSessionId());

				LocalDate date = LocalDate.parse(i.next());
				
				//System.out.println("Date "  + date)
				
				

				
				session.setDate(date);
				
				String room = i.next();

				//System.out.println("Room: " + room);
				session.setRoom(room);
				
				LocalTime time = LocalTime.parse(i.next());
				//System.out.println("Time: " + time);
				session.setTime(time);
				session.setTutorId(Integer.decode(i.next()));
				//System.out.println("Tutor ID: " + session.getTutorId());
				session.setCourse(i.next());
				//System.out.println("Course: " + session.getCourse());
				

				sessionList.add(session);
				
			}
			return sessionList;
		}finally {
			readSession.close();
		}
	}

	public static List<Student> getStudent() throws IOException {
		List<Student> studentList = new ArrayList<Student>();
		ReadCSV readStudent = new ReadCSV("Students.csv");
		try {
			// auto-generated primary key for authors table
			Integer userId = 1;
			Integer studentId = 1;
			String temp = "1";
			
			while (true) {
			List<String> tuple = readStudent.next();
			if (tuple == null) {
				break;
			}
			Iterator<String> i = tuple.iterator();
			Student stud = new Student();
			stud.setStudent_id(studentId++);
			stud.setYear(i.next());
			stud.setMajor(i.next());
			userId = Integer.decode(i.next());
			stud.setUser_Id(userId);
			studentList.add(stud);
		}
			return studentList;
		} finally {
				readStudent.close();
			}
		}

}