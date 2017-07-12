package com.ziumks.common.util;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 쓰레드 풀링
 * 
 * @version 1.0
 * @author Gunho,Kim
 */

public class ThreadPool extends HttpServlet {
	Log log = LogFactory.getLog(this.getClass());
	static ScheduledExecutorService executor;

	/**
	 * 서블릿 로드시 init
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		log.info("Create thread pool.");

		int threadPoolQuantity = 1;

		// 쓰레드 풀 생성
		executor = new ScheduledThreadPoolExecutor(threadPoolQuantity);
	}

	/**
	 * Runnable 인터페이스를 구현한 클래스를 실행한다.
	 * 
	 * @param command
	 */
	public static void execute(Runnable command) {
		// Runnable 인터페이스를 구현한 클래스를 실행
		executor.execute(command);
	}

	/**
	 * Runnable 인터페이스로 구현한 클래스를 ititialDelay 시간 이후로 period 시간을 기준으로 주기적으로 실행 시간
	 * 단위 : 초(SECONDS)
	 * 
	 * @param command
	 * @param initialDelay
	 * @param period
	 * @throws InterruptedException
	 */
	public static void scheduleAtFixedRate(Runnable command, long initialDelay,
	        long period) throws InterruptedException {
		executor.scheduleAtFixedRate(command, initialDelay, period,
		        TimeUnit.SECONDS);
	}

	public static void scheduleAtFixedDelay(Runnable command, long initialDelay,
	        long delay) {
		executor.scheduleWithFixedDelay(command, initialDelay, delay,
		        TimeUnit.SECONDS);
	}

	/**
	 * 서블릿이 언로드 될 때 모든 쓰레드를 종료시킴
	 */
	public void destroy() {
		super.destroy();

		log.info("Shut down the thread.");

		try {
			executor.shutdownNow();
			executor.awaitTermination(5000, TimeUnit.MILLISECONDS);

			if (!executor.isTerminated()) {
				log.info("Force shut down the thread.");
			}
		} catch (InterruptedException ie) {
			log.debug(ie.getMessage());
		}

	}

}
