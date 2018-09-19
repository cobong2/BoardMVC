<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <header id="top">
    <h1>${title}</h1>
  </header>
  <nav>
    <ul>
      <li><a href="main.bo">HOME</a></li>
      <li class="drop">
        <a class="button">BOARD</a>
        <section class="content">
          <a href="boardList.bo?btype=0">공지</a>
          <a href="boardList.bo?btype=1">자유</a>
          <a href="boardList.bo?btype=2">유머</a>
        </section>
      </li>
    </ul>
  </nav>