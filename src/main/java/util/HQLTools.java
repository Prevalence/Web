/**
 * 
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author John 执行HQL的工具类，封装HQL查询语句
 */
public class HQLTools {
	// src/main/resources/
	/**
	 * 主数据库配置对象
	 */
	private static Configuration masterConfiguration = new Configuration().configure("hibernateMaster.cfg.xml");// tomcat用这个
	/**
	 * 主数据库SessionFactory对象
	 */
	private static SessionFactory masterSessionFactory = masterConfiguration.buildSessionFactory();
	/**
	 * 从数据库配置对象
	 */
	private static Configuration slaveConfiguration = new Configuration().configure("hibernateSlave.cfg.xml");
	/**
	 * 从数据库SessionFactory对象
	 */
	private static SessionFactory slaveSessionFactory = slaveConfiguration.buildSessionFactory();

	/**
	 * 查询方法
	 * 
	 * @param operation
	 *            查询的语句
	 * @return 结果List，需要自己手动转为ArrayList
	 */
	@SuppressWarnings("rawtypes")
	public static List find(String operation) {
		Session session = slaveSessionFactory.openSession();
		session.beginTransaction();
		try {
			// 利用 session 建立 query

			Query query = session.createQuery(operation);

			// 序列化 query 的结果为一个 list 集合

			session.getTransaction().commit();

			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库查询出错-------");
			return null;
		} finally {
			session.close();
		}

	}

	/**
	 * 增加方法
	 * 
	 * @param objToAdd
	 *            需要增加的对象ArrayList<T>
	 * @return 增加结果
	 */
	public static <T> boolean add(ArrayList<T> objToAdd) {
		try {
			Session session = masterSessionFactory.openSession();
			session.beginTransaction();
			for (T t : objToAdd) {
				session.save(t);
			}
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库增加出错-------");
			return false;
		}

	}

	public static <T> boolean add(T objToAdd) {
		try {
			Session session = masterSessionFactory.openSession();
			session.beginTransaction();

			session.save(objToAdd);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库增加出错-------");
			return false;
		}
	}

	/**
	 * 删除方法
	 * 
	 * @param objToAdd
	 *            需要删除的对象ArrayList<T>
	 * @return 删除结果
	 */
	public static <T> boolean delete(ArrayList<T> objToDelete) {
		try {
			Session session = masterSessionFactory.openSession();
			session.beginTransaction();
			for (T t : objToDelete) {
				session.delete(t);
			}
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库删除出错-------");
			return false;
		}

	}

	public static <T> boolean delete(T objToDelete) {
		try {
			Session session = masterSessionFactory.openSession();
			session.beginTransaction();

			session.delete(objToDelete);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库删除出错-------");
			return false;
		}

	}

	/**
	 * 更新方法
	 * 
	 * @param objToAdd
	 *            需要更新的对象ArrayList<T>
	 * @return 更新结果
	 */
	public static <T> boolean update(ArrayList<T> objToUpdate) {
		try {
			Session session = masterSessionFactory.openSession();
			session.beginTransaction();
			for (T t : objToUpdate) {
				session.update(t);
			}
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库更新出错-------");
			return false;
		}

	}

	public static <T> boolean update(T objToUpdate) {
		try {
			Session session = masterSessionFactory.openSession();
			session.beginTransaction();

			session.update(objToUpdate);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库更新出错-------");
			return false;
		}
	}

	/**
	 * 提供给多线程块SessionFactory以创造绑定线程的Session
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return masterSessionFactory;
	}

	public static boolean executeQuery(String operation) {
		try {
			Session session = masterSessionFactory.openSession();
			session.beginTransaction();

			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(operation);
			query.executeUpdate();

			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------数据库执行Query出错-------");
			return false;
		}

	}

}
