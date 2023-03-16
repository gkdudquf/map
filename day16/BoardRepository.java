package day16;

import java.util.*;

public class BoardRepository {
	private Map<String, BoardDTO> map = new TreeMap<>();
	BoardDTO boardDTO = new BoardDTO();
	//BoardDTO타입만 List에 담을수있음
	List<BoardDTO> list = new ArrayList<>();

	//리턴타입:
	//메서드이름:
	//매개변수:
	public boolean save(BoardDTO boardDTO) {
		if (map.put(boardDTO.getBno(), boardDTO) == null) {
			return true;
		}
		return false;
	}

	public Map<String, BoardDTO> findAll() {
		return map;
	}

	public BoardDTO findById(String bno) {
		for (String Bno : map.keySet()) {
			if (map.get(Bno).getBno().equals(bno)) {
				return map.get(Bno);
			}
		}
		return null;

	}

	public boolean updateNew(BoardDTO boardDTO, String bno) {
		for (String Bno : map.keySet()) {
			if (map.get(Bno).getBno().equals(bno)) {
				map.get(Bno).setTitle(boardDTO.getTitle());
				map.get(Bno).setWriter(boardDTO.getWriter());
				return true;
			}
		}
		return false;
	}

	public boolean delete(String bno) {
		for (String Bno : map.keySet()) {
			if (map.get(Bno).getBno().equals(bno)) {
				map.remove(Bno);
				return true;
			}
		}
		return false;
	}

	public List<BoardDTO> findByWriter(){
		return list;
	}

}
