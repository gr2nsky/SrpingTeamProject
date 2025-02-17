//package com.team4.ysms.controller;
//
//import java.io.IOException;
//
//
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.simple.JSONArray;
//
//import com.team4.ysms.command.AdminUserDeleteCommand;
//import com.team4.ysms.command.AdminUserListCommand;
//import com.team4.ysms.command.AnnounceCommand;
//import com.team4.ysms.command.AnnounceContentCommand;
//import com.team4.ysms.command.AnnounceDeleteCommand;
//import com.team4.ysms.command.AnnounceModifyCommand;
//import com.team4.ysms.command.AnnounceWriteCommand;
//import com.team4.ysms.command.AuthEmailRequestCommand;
//import com.team4.ysms.command.Command;
//import com.team4.ysms.command.ContentCommand;
//import com.team4.ysms.command.DeleteCommand;
//import com.team4.ysms.command.DeleteQnACommand;
//import com.team4.ysms.command.DeleteReviewCommand;
//import com.team4.ysms.command.DetailViewCommand;
//import com.team4.ysms.command.DetailViewQnACommand;
//import com.team4.ysms.command.DetailViewReviewCommand;
//import com.team4.ysms.command.DupleEmailCheckCommand;
//import com.team4.ysms.command.DupleIDCheckCommand;
//import com.team4.ysms.command.FindAccountCommand;
//import com.team4.ysms.command.HostDeleteQnACommand;
//import com.team4.ysms.command.HostModifyQnACommand;
//import com.team4.ysms.command.HostQnACommand;
//import com.team4.ysms.command.HostWriteQnACommand;
//import com.team4.ysms.command.ListCommand;
//import com.team4.ysms.command.LoginCommand;
//import com.team4.ysms.command.LogoutCommand;
//import com.team4.ysms.command.ModifyCommand;
//import com.team4.ysms.command.ModifyQnACommand;
//import com.team4.ysms.command.ModifyReviewCommand;
//import com.team4.ysms.command.MyInfoFormCommand;
//import com.team4.ysms.command.MyInfoUpdateCommand;
//import com.team4.ysms.command.MyinfoQnACommand;
//import com.team4.ysms.command.MyinfoRentalPreviousCommand;
//import com.team4.ysms.command.MyinfoRentalScheduledCommand;
//import com.team4.ysms.command.MyinfoReviewCommand;
//import com.team4.ysms.command.PaymentCommand;
//import com.team4.ysms.command.PaymentResultCheckCommand;
//import com.team4.ysms.command.PaymentSubmitCommand;
//import com.team4.ysms.command.PlaceListAllCommand;
//import com.team4.ysms.command.QnACommand;
//import com.team4.ysms.command.ReservationCommand;
//import com.team4.ysms.command.ReviewCommand;
//import com.team4.ysms.command.SearchPlaceCommand;
//import com.team4.ysms.command.SignUpInputCommand;
//import com.team4.ysms.command.UserDetailViewCommand;
//import com.team4.ysms.command.WriteCommand;
//import com.team4.ysms.command.WriteQnACommand;
//import com.team4.ysms.command.WriteReviewCommand;
//import com.team4.ysms.command.WriteSpaceCommand;
//import com.team4.ysms.command.paymentResultDetailViewCommand;
//
///**
// * Servlet implementation class FrontController
// */
//@WebServlet("*.four")
//public class FrontController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    public FrontController() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("<<< doGet() >>>");
//		actionFour(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("<<< doPost() >>>");
//		actionFour(request, response);
//	}
//
//	protected void actionFour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("<<< actionFour() >>>");
//		request.setCharacterEncoding("utf-8");
//		
//		String viewPage = null;
//		Command command = null;
//
//		String uri = request.getRequestURI();
//		String conPath = request.getContextPath();
//		String com = uri.substring(conPath.length());
//		
//		// Check Log . . .
//		System.out.println("< Request Context Path : " + conPath + " >");
//		System.out.println("< Request com : " + com + " >");
//		
//
//		switch (com) {
//			// Mypage  * * * * * * * * * * * * * *
//				
//			case "/mypage.four":
//				command = new MyInfoFormCommand();
//				command.execute(request, response);
//				viewPage = "myPage.jsp";
//				break;
//				
//			case "/myInfoUpdateForm.four":
//				command = new MyInfoFormCommand();
//				command.execute(request, response);
//				viewPage = "myInfoUpdateProfile.jsp";
//				break;
//			
//			case "/myInfoUpdate.four":
//				command = new MyInfoUpdateCommand();
//				command.execute(request, response);
//				viewPage = "myInfoUpdateForm.four";
//				break;
//				
//			/*
//			 * myInfo - rental list and write review
//			 */
//			// myInfo rental List(예정된예약) 보여주기
//			case ("/myinfo_rental_scheduled.four") :
//				command = new MyinfoRentalScheduledCommand();
//				command.execute(request, response);
//				viewPage = "myinfoRentalList_scheduled.jsp";
//				break;
//			// myInfo rental List(이전 예약) 보여주기
//			case ("/myinfo_rental_previous.four") :
//				command = new MyinfoRentalPreviousCommand();
//				command.execute(request, response);
//				viewPage = "myinfoRentalList_previous.jsp";
//				break;	
//			//추가 2021 05 27 윤재필
//			case "/paymentResultDetailView.four":
//				command = new paymentResultDetailViewCommand();
//				command.execute(request, response);
//				viewPage = "paymentResultCheck.jsp";
//				break;
//				
//			// * * * * * * * * * * * * * * * * * *//
//				
//			// Place Search * * * * * * * * * * * 
//				
//				// PlaceSearchPage 보여주기
//			case ("/SearchPlacePage.four"):
//				System.out.println("PlaceSearchPage.jsp 출력시도");
//				command = new PlaceListAllCommand(); 
//				command.execute(request, response); 
//				viewPage = "PlaceSearchPage.jsp"; 
//				break;
//			
//			// PlaceResultPage 보여주기
//			case ("/SearchPlaceCommand.four"): 
//				System.out.println("PlaceSearch/PlaceResultPage.jsp 출력시도");
//				command = new SearchPlaceCommand(); // Command 대신 SearchLocationCommand 사용가능
//				command.execute(request, response); // Dao 실행
//				viewPage = "PlaceResultPage.jsp"; // 화면 출력
//				break;	
//				
//			// * * * * * * * * * * * * * * * * * *//
//				
//				
//			// Detail View (Space) * * * * * * * *
//			case "/list.four":
//				command = new ListCommand();
//				command.execute(request, response);
//				viewPage = "list.jsp";
//				break;
//	
//
//			case "/detail.four":
//				command = new DetailViewCommand();
//				command.execute(request, response);
//				viewPage = "detail.jsp";
//				break;
//				
//			case "/reservation.four":
//				command = new ReservationCommand();
//				command.execute(request, response);
//				viewPage = "reservation.jsp";
//				break;	
//				
//			case "/payment.four":
//				command = new PaymentCommand();
//				command.execute(request, response);
//				viewPage = "payment.jsp";
//				break;
//				
//			case "/successPayment.four":
//				command = new PaymentSubmitCommand();
//				command.execute(request, response);
//				viewPage = "paymentResult.jsp";
//				break;
//				
//			case "/paymentResultCheck.four":
//				command = new PaymentResultCheckCommand();
//				command.execute(request, response);
//				viewPage = "paymentResultCheck.jsp";
//				break;
//				
//			// * * * * * * * * * * * * * * * * * *//
//			
//			// Share Space CRUD (Host User) * * * * 
//			case "/content.four":
//				command = new ContentCommand();
//				command.execute(request, response);
//				viewPage = "content.jsp";
//				break;
//				
//			case "/write_space.four":
//				viewPage = "writeSpace.jsp";
//				break;
//				
//			case "/write_detail.four":
//				command = new WriteSpaceCommand();
//				command.execute(request, response);
//				viewPage = "write.jsp";
//				break;
//
//			case "/write.four":
//				command = new WriteCommand();
//				command.execute(request, response);
//				viewPage = "list.four?page=1";
//				break;
//				
//			case "/modify.four":
//				command = new ModifyCommand();
//				command.execute(request, response);
//				viewPage = "list.four?page=1";
//				break;
//
//			// 공유한 공간 지우기
//			case "/delete.four":
//				command = new DeleteCommand();
//				command.execute(request, response);
//				viewPage = "list.four?page=1";
//				break;
//			// * * * * * * * * * * * * * * * * * *//
//
//			
//			// QnA 작성페이지 * * * * * * [210520 HK]
//			case ("/write_qna.four") :
//				viewPage = "write_QnA.jsp";
//			break;
//			
//			// QnA 작성 후 List 보여주기
//			case ("/qna_write.four") :
//				command = new WriteQnACommand();
//				command.execute(request, response);
//				viewPage = "write_QnA_Completed.jsp";
//			break;
//			
//			// QnA List 보여주기
//			case ("/qna.four") :
//				command = new QnACommand();
//				command.execute(request, response);
//				viewPage = "view_QnA.jsp";
//				break;
//				
//			// Review List 보여주기
//			case ("/review.four") :
//				command = new ReviewCommand();
//				command.execute(request, response);
//				viewPage = "view_Review.jsp";
//				break;
//				
//				
//			// QnA 작성페이지 1) * * * * * [210521 HK]
//			// * * * * My Info QnA (User) * * * * 
//				
//			// myInfoQnAList 보여주기 -> user
//			case ("/myinfo_qna.four") :
//				command = new MyinfoQnACommand();
//				command.execute(request, response);
//				viewPage = "view_myinfo_QnA.jsp";
//				break;
//			
//			// Qna Delete 하기 -> user
//			case("/deleteCheck_qna.four") :
//				viewPage = "delete_QnA_check.jsp";
//				break;
//			
//			case("/qna_delete.four") :
//				command = new DeleteQnACommand();
//				command.execute(request, response);
//				viewPage = "delete_QnA_Completed.jsp";
//				break;
//				
//			// Qna modify를 위해 detailView 보여주기 -> user
//			case("/modify_qna.four") :
//				command = new DetailViewQnACommand();
//				command.execute(request, response);
//				viewPage = "modify_QnA.jsp";
//				break;
//					
//			case("/qna_modify.four") :
//				command = new ModifyQnACommand();
//				command.execute(request, response);
//				viewPage = "modify_QnA_Completed.jsp";
//				break;
//					
//					
//			// QnA 작성페이지 2) * * * * * [210521 HK]
//			// * * * * My Info QnA (Host) * * * * 
//					
//				// host가 올린 공간에 대한 QnA List
//			case("/host_qna.four") :
//				command = new HostQnACommand();
//				command.execute(request, response);
//				viewPage = "view_Host_QnA.jsp";
//				break;
//			
//			case("/host_write_qna.four") :
//				command = new DetailViewQnACommand();
//				command.execute(request, response);
//				viewPage = "Host_Write_QnA.jsp";
//				break;
//					
//			case("/host_qna_write.four") :
//				command = new HostWriteQnACommand();
//				command.execute(request, response);
//				viewPage = "Host_Write_QnA_Completed.jsp";
//				break;
//			
//			case("/host_modify_qna.four") :
//				command = new DetailViewQnACommand();
//				command.execute(request, response);
//				viewPage = "Host_Modify_QnA.jsp";
//				break;
//			
//			case("/host_qna_modify.four") :
//				command = new HostModifyQnACommand();
//				command.execute(request, response);
//				viewPage = "Host_Modify_QnA_Completed.jsp";
//				break;
//					
//			case("/host_deleteCheck_qna.four") :
//				viewPage = "Host_Delete_QnA_check.jsp";
//
//				break;
//				
//			case("/host_qna_delete.four") :
//				command = new HostDeleteQnACommand();
//				command.execute(request, response);
//				viewPage = "Host_Delete_QnA_Completed.jsp";
//				break;
//			
//			// Review * * * * * * * * * * * [210524 HK]
//			/*
//			 * 21.05.23 hyokyeong
//			 * myInfo -> rental list-> review
//			 */
//			// review 작성하기
//			case ("/write_review.four") :
//				viewPage = "write_Review.jsp";
//				break;
//			case ("/review_write.four") :
//				command = new WriteReviewCommand();
//				command.execute(request, response);
//				viewPage = "write_Review_Completed.jsp";
//				break;
//			// Review detail view
//			case ("/detail_review.four") :
//				command = new DetailViewReviewCommand();
//				command.execute(request, response);
//				viewPage = "detailView_Review.jsp";
//				break;
//			// modify review
//			case ("/modify_review.four") :
//				viewPage = "modify_Review.jsp";
//				break;
//			// modify review
//			case ("/review_modify.four") :
//				command = new ModifyReviewCommand();
//				command.execute(request, response);
//				viewPage = "modify_Review_Completed.jsp";
//				break;
//			// delete review
//			case("/deleteCheck_review.four") :
//				viewPage = "delete_Review_check.jsp";
//				break;
//			case("/review_delete.four") :
//				command = new DeleteReviewCommand();
//				command.execute(request, response);
//				viewPage = "delete_Review_Completed.jsp";
//				break;
//			/*
//			 * 21.05.23 hyokyeong
//			 * myInfo - my review list
//			 */
//			case("/myinfo_review.four") :
//				command = new MyinfoReviewCommand();
//				command.execute(request, response);
//				viewPage = "view_myinfoReview.jsp";
//				break;
//			
//				
//				
//				
//			// * * * * * * * * * * * * * * * * * *//	
//				
//			// Announce  * * * * * * * [210521 JY]
//				
//				// Announce _admin: List/Content 보여주기	
//			case("/announce_admin.four"):
//				command = new AnnounceCommand();
//				command.execute(request, response);
//				viewPage = "announce_admin.jsp";
//				break;
//				
//			case("/announceContent_view_admin.four"):
//				command = new AnnounceContentCommand();
//				command.execute(request, response);
//				viewPage = "announceContent_view_admin.jsp";
//				break;
//
//				// Announce _admin CRUD
//			case("/announceWrite_view_admin.four"):
//				viewPage = "announceWrite_view_admin.jsp";
//				break;
//
//			case("/announceWrite_admin.four"):
//				command = new AnnounceWriteCommand();
//				command.execute(request, response);
//				viewPage = "announce_admin.four";
//				break;
//				
//			case("/announceDelete_admin.four"):
//				command = new AnnounceDeleteCommand();
//				command.execute(request, response);
//				viewPage = "announce_admin.four";
//				break;
//				
//			case("/announceModify_admin.four"):
//				command = new AnnounceModifyCommand();
//				command.execute(request, response);
//				viewPage = "announce_admin.four";
//				break;
//				
//				//amdin managing page : 2021-05-25 윤재필
//			case "/admin_managingUser.four":
//				command = new AdminUserListCommand();
//				command.execute(request, response);
//				viewPage = "admin_userList.jsp";
//				break;
//			case "/userDelete.four":
//				command = new AdminUserDeleteCommand();
//				command.execute(request, response);
//				viewPage = "admin_managingUser.four";
//				break;
//			case "/userDetailView.four":
//				command = new UserDetailViewCommand();
//				command.execute(request, response);
//				viewPage = "userDetailView.jsp";
//				break;			
//				
//				// Announce _user : List/Content 보여주기	
//			case("/announce_user.four"):
//				command = new AnnounceCommand();
//				command.execute(request, response);
//				viewPage = "announce_user.jsp";
//				break;
//				
//			case("/announceContent_view_user.four"):
//				command = new AnnounceContentCommand();
//				command.execute(request, response);
//				viewPage = "announceContent_view_user.jsp";
//				break;
//			// * * * * * * * * * * * * * * * * * *//
//				
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//		dispatcher.forward(request, response);
//
//		
//	}
//	
//}
