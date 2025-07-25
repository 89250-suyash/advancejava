package daos;

import java.util.List;

import pojos.Candidate;

public interface CandidateDao extends AutoCloseable {
	List<Candidate> findAll() throws Exception;
	Candidate findById(int id) throws Exception;
	int save(Candidate c) throws Exception;
	int update(Candidate c) throws Exception;
	int deleteById(int id) throws Exception;
	int incrVote(int candId) throws Exception;
}

