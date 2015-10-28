package fi.pizzablue.controller;
 
import java.io.IOException;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.pizzablue.bean.Ostoskori;
 
public class OstoskoriController extends HttpServlet {
  

	private static final long serialVersionUID = 1L;

  
 public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
  String strAction = request.getParameter("action");
   
   
  if(strAction!=null && !strAction.equals("")) {
   if(strAction.equals("add")) {
    addToCart(request);
  /* } else if (strAction.equals("Update")) {
    updateCart(request);*/
   } else if (strAction.equals("Delete")) {
    deleteCart(request);
   }
  }
  response.sendRedirect("../ShoppingCart.jsp");
 }
  
 protected void deleteCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String strItemIndex = request.getParameter("itemIndex");
  Ostoskori cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
  if(objCartBean!=null) {
   cartBean = (Ostoskori) objCartBean ;
  } else {
   cartBean = new Ostoskori();
  }
  cartBean.poistaOstoskorista(strItemIndex);
 }
  
 /*protected void updateCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String strQuantity = request.getParameter("quantity");
  String strItemIndex = request.getParameter("itemIndex");
  
  Ostoskori cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
  if(objCartBean!=null) {
   cartBean = (Ostoskori) objCartBean ;
  } else {
   cartBean = new Ostoskori();
  }
  cartBean.updateCartItem(strItemIndex, strQuantity);
 }*/
  
 protected void addToCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String strModelNo = request.getParameter("modelNo");
  String strDescription = request.getParameter("description");
  String strPrice = request.getParameter("price");
  String strQuantity = request.getParameter("quantity");
   
  Ostoskori cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
 
  if(objCartBean!=null) {
   cartBean = (Ostoskori) objCartBean ;
  } else {
   cartBean = new Ostoskori();
   session.setAttribute("cart", cartBean);
  }
   
  cartBean.lisaaOstoskoriin(strModelNo, strDescription, strPrice, strQuantity);
 }
 
}