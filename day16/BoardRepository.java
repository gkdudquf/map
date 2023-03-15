package day16;

import java.util.*;

public class BoardRepository {
	private Map<String, BoardDTO> map = new TreeMap<>();
	BoardDTO boardDTO = new BoardDTO();
	List<BoardDTO> list = new ArrayList<>();

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

	public boolean update(BoardDTO boardDTO, String bno) {
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
