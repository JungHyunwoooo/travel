package Travel.control;

import java.util.List;
import java.util.Scanner;

import Travel.dao.TravelDAO;
import Travel.vo.TravelVO;

/*
 * 사용자 입력을 가이드, 처리된 결과를 출력등
 */

public class TravelControl {
	Scanner sc = new Scanner(System.in);
	TravelDAO tdao = new TravelDAO();

	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("==============================================");
			System.out.println("1.고객정보  2.고객등록  3.고객정보 수정  4.고객정보 삭제  5.추천여행지  6.종료");
			System.out.println("선택> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				custList();
				break;
			case 2:
				addCust();
				break;
			case 3:
				modifyCust();
				break;
			case 4:
				removeCust();
				break;
			case 5:
				recmdManager();
				break;
			case 6:
				System.out.println("즐거운 여행되세요!");
				isTrue = false;
			}
		}
	}//end of run




	void recmdManager() {
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("=============================================");
			System.out.println("국가         예산(인당)           비행시간(Hour)");
			System.out.println("=============================================");
			System.out.println("일본         700,000원           최소 2시간 20분");
			System.out.println("중국         450,000원	        최소 1시간 50분");
			System.out.println("베트남       600,000원	        최소 5시간 15분");
			System.out.println("스페인       4,000,000원         최소 14시간 25분");
			System.out.println("-----------------------------------------------");
			System.out.println("상세보기(V)  다음 페이지(N)  이전 페이지(B)  홈으로(H)");
			System.out.println("선택> ");
			String recmdSpot = (sc.nextLine());
			
			switch (recmdSpot) {
			case "V":
				view();
				break;
			case "N":
				nextP();
				break;
			case "B":
				beforeP();
				break;
			case "H":
				System.out.println("홈으로 돌아갑니다.");
				isTrue = false;
			}
		}
	}//end of recmdManager



	//상세보기.
	void view() {
		System.out.println(">나라를 선택하시오.  ");
		String view = sc.nextLine();
	}//end of view

	//다음 페이지.
	private void nextP() {
		
	}//end of nextP
	
	//이전 페이지.
	private void beforeP() {
		
	}//end of beforeP
	
	

	// 목록 출력 기능.
	void custList() {
		List<TravelVO> travels = tdao.selectList();
		System.out.println("==============================================");
		System.out.println("고객번호   이름     성별      연락처       예산      ");
		System.out.println("==============================================");
		for (TravelVO svo : travels) {	
			System.out.println(svo.briefShow());
		}
	}// end of studentList().
	
	//고객등록
	void addCust() {
		System.out.println(">고객번호를 입력하시오.   [예) 'T-00']");
		String cNo = sc.nextLine();

		System.out.println(">고객이름을 입력하시오.");
		String cName = sc.nextLine();

		System.out.println(">성별을 입력하시오.");
		String cSex = sc.nextLine();

		System.out.println(">연락처를 입력하시오.   [예) '000-0000-0000']");
		String cPhone = sc.nextLine();

		System.out.println(">예상경비를 입력하시오.");
		String cMoney = sc.nextLine();
		
		TravelVO cust = new TravelVO();
		cust.setCustNo(cNo);
		cust.setCustName(cName);
		cust.setCustSex(cSex);
		cust.setCustPhone(cPhone);
		cust.setCustMoney(cMoney);

		// 입력기능 호출.
		if (tdao.insertCust(cust)) {
			System.out.println("등록완료!");
		} else {
			System.out.println("처리 중 예외발생!");
		}

	}//end of addCust
	
	//고객수정
	private void modifyCust() {
		String no = ""; // 블럭레벨 변수.
		while (true) {
			System.out.println("고객번호를 입력하시오.>   [예) 'T-00']");
			no = sc.nextLine();
			if (tdao.selectExit(no) == 1) {
				// 고객번호 존재한다는 의미.
				break;
			}
			System.out.println("찾는 고객번호가 없음!!! 고객번호 다시 입력>  ");
		}
		
		System.out.println("변경할 이름을 입력하시오.>  ");
		String name = sc.nextLine();

		System.out.println("성별을 변경하시오.>  ");
		String sex = sc.nextLine();

		System.out.println("변경할 연락처를 입력하시오.>  ");
		String phone = sc.nextLine();
		
		System.out.println("예상경비를 입력하시오.>  ");
		String money = sc.nextLine();
		
		TravelVO custVO = new TravelVO();
		custVO.setCustNo(no);
		custVO.setCustName(name);
		custVO.setCustSex(sex);
		custVO.setCustPhone(phone);
		custVO.setCustMoney(money);
		
		if (tdao.updateCust(custVO)) {
			System.out.println("수정완료!");
		}
	}//end of modifyCust
	
	// 삭제 기능.
		void removeCust() {
			System.out.println("삭제할 고객번호>   [예) 'T-00']");
			String cNo = sc.nextLine();
			if (tdao.removeCust(cNo) == 1) {
				System.out.println("삭제완료!");
			} else {
				System.out.println("삭제처리 중 문제발생!");
			}
			
		}//end of removeStudent
		
}
