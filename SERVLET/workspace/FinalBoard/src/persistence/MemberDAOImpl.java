package persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import orm.DBBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	private static Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private static String namespace ="mapper.memberMapper";
	
	public MemberDAOImpl () {
		new DBBuilder();
		sql=DBBuilder.getFactory().openSession();
	}

	@Override
	public boolean insert(MemberDTO mdto) {
		sql.insert(namespace+".madd", mdto);
		sql.commit();
//		sql.close();
		return true;
	}

	@Override
	public MemberDTO login(MemberDTO mdto) {
		return sql.selectOne(namespace+".mlogin", mdto);
	}

	@Override
	public int checkEmail(String email) {
		Integer flag =sql.selectOne(namespace+".checkEmail", email);
		log.info("flag:", flag);
		return flag;
	}

	@Override
	public List<MemberDTO> getList() {
		return sql.selectList(namespace+".mlist");
	}

	@Override
	public int destory(String email) {
		
		return sql.delete(namespace+".mdestory", email);
	}
}
