package day17_teacher;

import java.util.*;

public class BoardRepository {
//BoardRepository:데이터를 DB에 저장하는 역할 

	private Map<String, BoardDTO> boardMap = new HashMap<>();

	public boolean save(BoardDTO boardDTO) {
		BoardDTO result = boardMap.put(boardDTO.getBno(), boardDTO);
		if(result == null) {
			return true;
		}else {
		return false;
		}
	}

	public Map<String, BoardDTO> findAll() {
		return boardMap;

	}

	public BoardDTO findById(String bno) {
		for (String key : boardMap.keySet()) {
			if (boardMap.get(key).getBno().equals(bno)) {
				return boardMap.get(key);
			}
		}
		return null;
	}

	public boolean findById2(String bno) {
		if (boardMap.containsKey(bno)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateNew(String bno , String updateTitle , String updateWriter) {

		for (String key : boardMap.keySet()) {
			if (boardMap.get(key).getBno().equals(bno)) {
				boardMap.get(key).setTitle(updateTitle);
				boardMap.get(key).setWriter(updateWriter);
				return true;
			}
		}
		return false;
	}

	public boolean delete(BoardDTO BoardDTO, String bno) {

		for (String key : boardMap.keySet()) {
			if (boardMap.get(key).getBno().equals(bno)) {
				boardMap.remove(key);
				return true;
			}
		}
		return false;
	}

	public List<BoardDTO> search(String q){
		List<BoardDTO> searchList = new ArrayList<>();
		for(String key: boardMap.keySet()) {
			if(q.equals(boardMap.get(key).getWriter())) {
				searchList.add(boardMap.get(key));
				//BoardDTO result = boaedMap.get(key);
				//searchList.add(result);
				//return searchList; 여기에 넣으면 하나만 찾아도 바로 리턴해버림
			}
		}
		return searchList;
	}
	
	
}
