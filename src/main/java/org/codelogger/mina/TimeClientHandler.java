package org.codelogger.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TimeClientHandler extends IoHandlerAdapter {

  public TimeClientHandler() {

  }

  @Override
  public void messageReceived(final IoSession session, final Object message) throws Exception {

    System.out.println("接收到新消息：" + message);// 显示接收到的消息
  }
}
