package day16;

import java.util.*;

public class BoardService {
	BoardRepository br = new BoardRepository();
	Scanner sc = new Scanner(System.in);

	public void save() {
		BoardDTO boardDTO = new BoardDTO();
		System.out.print("제목> ");
		boardDTO.setTitle(sc.nextLine());
		System.out.print("작성자> ");
		boardDTO.setWriter(sc.next());
		sc.nextLine();

		if (br.save(boardDTO)) {
			List<BoardDTO> list = br.findByWriter();
			list.add(boardDTO);
			System.out.println("게시글 등록완료!");
		} else {
			System.out.println("게시글 등록실패ㅜ");
		}
	}

	public void findAll() {
		Map<String, BoardDTO> map = br.findAll();
		System.out.println("글번호\t제목\t\t작성자\t조회수\t게시일");
		System.out.println("--------------------------------------");
		for (String bno : map.keySet()) {
			System.out.println(map.get(bno));
		}
	}

	public void testdater() {
		for (int i = 1; i <= 5; i++) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBno("B" + "10" + (i - 1));
			boardDTO.setTitle("title" + i);
			boardDTO.setWriter("writer" + i);
			br.save(boardDTO);
		}
	}

	public void findById() {
		System.out.print("읽을 글번호> ");
		String bno = sc.next();
		BoardDTO boardDTO = br.findById(bno);
		if (boardDTO == null) {
			System.out.println("찾을 수 없는 글입니다");
		} else {
			boardDTO.increaseCnt();
			System.out.println("글번호\t제목\t\t작성자\t조회수\t게시일");
			System.out.println("--------------------------------------");
			boardDTO.print();
		}
	}

	public void update() {
		System.out.print("수정할 글번호> ");
		String bno = sc.next();
		sc.nextLine();
		BoardDTO b = br.findById(bno);
		if (b == null) {
			System.out.println("조회할 수 없는 글번호 입니다");
		} else {
//			BoardDTO boardDTO = new BoardDTO();
			System.out.print("수정할 제목> ");
//			boardDTO.setTitle(sc.nextLine());
			String updateTitle = sc.next();
			System.out.print("수정할 작성자> ");
//			boardDTO.setWriter(sc.next());
			String updateWriter = sc.next();
			sc.nextLine();
			BoardDTO boardDTO = new BoardDTO(updateTitle, updateWriter);
			if (br.updateNew(boardDTO, bno)) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
		}
	}
	//refactoring 완성된 코드를 다시 보면서 불필요한 것들을 재정리하는 것
	public void delete() {
		System.out.print("삭제할 글번호> ");
		String bno = sc.next();sc.nextLine();
		boolean result = br.delete(bno);
//		if (br.delete(bno)) {
		if(result) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
	}

	public void search() {
		System.out.println("작성자 > ");
		String writer = sc.next();
		List<BoardDTO> list = br.findByWriter();
		System.out.println("글번호\t제목\t\t작성자\t조회수\t게시일");
		System.out.println("--------------------------------------");
		for (BoardDTO b : list) {
			if (b.getWriter().equals(writer)) {
				System.out.println(b);
			}

		}

	}

}

//System.out.println("글번호\t제목\t\t작성자\t조회수\t게시일");
//System.out.println("--------------------------------------");
