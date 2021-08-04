package rc.bootsecurity.Services;

import javafx.scene.chart.ScatterChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Component
public class UserService implements MyService<User> {
//	private final static String URL = "jdbc:mysql://localhost:3306/db1";
//	private final static String USERNAME = "root";
//	private final static String PWD = "q12345";
//	private static Connection conn;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

////	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
////	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/tutorialDb";
////
////	// JDBC Database Credentials
////	static final String JDBC_USER = "root";
////	static final String JDBC_PASS = "admin@123";
//
//	//private static GenericObjectPool gPool = null;
//
//	{
////		try {
////			// The newInstance() call is a work around for some
////			// broken Java implementations
////			Class.forName("com.mysql.jdbc.Driver").newInstance();
////		} catch (Exception ex) {
////			ex.printStackTrace();
////		}
//
////		new BasicDataSource();
////		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
////		gPool = new GenericObjectPool();
//
//
//		try {
//			conn = DriverManager.getConnection(URL +
//							"?user=" + USERNAME +
//							"&password=" + PWD);
//
//		} catch (SQLException ex) {
//			System.out.println("SQLException: " + ex.getMessage());
//			System.out.println("SQLState: " + ex.getSQLState());
//			System.out.println("VendorError: " + ex.getErrorCode());
//		}
//	}


	public Page<User> getPage(Pageable page) {
		return userRepository.findAll(page);
//		try {
//			Statement statement = conn.createStatement();
//			ResultSet rset = statement.executeQuery("SELECT * FROM users");
//
//			while (rset.next()) {
//				User user = new User();
//				user.setId(rset.getInt("id"));
//				user.setName(rset.getString("name"));
//				list.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
	}


	public Optional<User> show(long id) {
		return userRepository.findById(id);

	}



	public Optional<User> findByName(String name) {
//		try {
			User u = userRepository.findByUsername(name);
			return Optional.ofNullable(u);
//		}
//		catch (Exception ex) {
//			throw new Exception("qqq");
//		}
//		return Optional.empty();
	}


	//@Transactional
	public User save(User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		Set<Role> roles = new HashSet<>();
//		roles.add(roleDao.getOne(1L));
//		user.setRoles(roles);
		//userRepository.save(user);

		return userRepository.save(user);
	}



	public void delete(long id) {
		userRepository.deleteById(id);
	}

}








//
//@Component
//public class UsersDAO {
//	private static int userid = 0;
//
//	ArrayList<User> users;
//
//	{
//		users = new ArrayList<>();
//
//		users.add(new User(++userid, "Vasya"));
//		users.add(new User(++userid, "Rosa"));
//		users.add(new User(++userid, "Luna))"));
//	}
//
//	public List<User> index() {
//		return users;
//	}
//
//
//	public Optional<User> show(int id) {
//		return users.stream().filter(u -> u.getId() == id).findAny();//.orElse(null);
//	}
//
//
//	public boolean save(User user) {
//		user.setId(++userid);
//		return users.add(user);
//	}
//
//
//	public boolean update(User user) {
//		User userToBeUpdated = show(user.getId()).get();
//		if (user == null)
//			return false;
//		return userToBeUpdated.setName(user.getName());
//	}
//
//
//	public boolean delete(int id) {
//		return users.removeIf(e -> e.getId() == id);
//	}
//
//}
