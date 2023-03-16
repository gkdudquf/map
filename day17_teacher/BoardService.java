package day17_teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoardService {

	BoardRepository br = new BoardRepository();
	Scanner sc = new Scanner(System.in);

	public void save() {
		BoardDTO boardDTO = new BoardDTO();
		System.out.println("제목> ");
		boardDTO.setTitle(sc.nextLine());
		System.out.println("작성자> ");
		boardDTO.setWriter(sc.next());
		sc.nextLine();

		boolean success = br.save(boardDTO);
		if (success = true) {
			System.out.println("게시글 등록완료!");
		} else {
			System.out.println("게시글 등록실패");
		}

	}

	public void findAll() {
		Map<String, BoardDTO> boardMap = br.findAll();
		// List<String> keySet = new ArrayList<>(boardMap.keySet());
		// Collections.sort(keySet);// Key 값 기준 오름차순
		// Collections.sort(keySet,Collections.reverseOrder());//Key 값 기준 내림차순
		List<String> keySet = new ArrayList<>(boardMap.keySet());
		keySet.sort(Comparator.naturalOrder());
		System.out.println("글번호\t제목\t작성자\t조회수\t게시일");
		System.out.println("----------------------------------------------------------");
		for (String key : keySet) {
			boardMap.get(key).print();
		}
	}

	public void findById() {
		System.out.println("읽을 번호> ");
		String bno = sc.next();
		BoardDTO boardDTO = br.findById(bno);
		if (boardDTO == null) {
			System.out.println("찾을수없는 글입니다");
		} else {
			boardDTO.increaseCnt();
			System.out.println("글번호\t제목\t작성자\t조회수\t게시일");
			System.out.println("----------------------------------------------------------");
			boardDTO.print();
		}

	}

	public void update() {

		System.out.println("수정할 글번호> ");
		String bno = sc.next();
		sc.nextLine();
		BoardDTO b = br.findById(bno);
		if (b == null) {
			System.out.println("조회할 수 없는 글번호입니다");
		} else {
			//BoardDTO boardDTO = new BoardDTO();
			System.out.println("수정할 제목> ");
			//boardDTO.setTitle(sc.nextLine());
			String updateTitle = sc.nextLine();
			System.out.println("수정할 작성자> ");
			//boardDTO.setWriter(sc.next());
			String updateWriter = sc.next();
			sc.nextLine();
			if (br.updateNew(bno, updateTitle , updateWriter)) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
		}
	}

	public void delete() {
		System.out.println("삭제할 글번호> ");
		String bno = sc.next();
		sc.nextLine();
		BoardDTO b = br.findById(bno);
		if (b == null) {
			System.out.println("조회할 수 없는 글번호입니다");
		} else {
			BoardDTO boardDTO = new BoardDTO();
			if (br.delete(boardDTO, bno)) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		}

	}

//	public boolean duCheck() { // 중복번호체크
//		System.out.println("확인할 글번호 입력");
//		String name = sc.next();
//		if (br.findById2(name)) {
//			System.out.println("중복된 번호가 있습니다");
//			return false;
//		} else {
//			System.out.println("생성 가능한 글번호입니다");
//			return true;
//		}
//	}

	public void testData() {
		BoardDTO boardDTO = new BoardDTO();
		for(int i=1; i<=5; i++) {
			boardDTO.setTitle("title"+i);
			//String newTitle = "title" + i;
			//boardDTO.setTitle(newTitle);
			boardDTO.setWriter("writer"+i);
			br.save(boardDTO);
		}
	}
	
	public void search(){
		System.out.println("검색어> ");
		String q = sc.nextLine();
		List<BoardDTO> searchList = br.search(q);
		for(BoardDTO b: searchList) {
			b.print();
		}
	}
	
	

}



