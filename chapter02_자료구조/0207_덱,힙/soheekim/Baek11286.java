package study0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

public class Baek11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> listp = new LinkedList<>();
		LinkedList<Integer> listm = new LinkedList<>();
		StringBuffer sb = new StringBuffer();

		String[] Ntemp = bfr.readLine().split(" ");
		int N = Integer.parseInt(Ntemp[0]);
		int order;
		int printnum;
		int lptemp;
		int lmtemp;

		for (int i = 0; i < N; i++) {
			order = Integer.parseInt(bfr.readLine());

			if (order == 0) {
				if (listp.size() + listm.size() == 0)
					sb.append("0").append("\n");
				else {
					if (listp.size() == 0)
						lptemp = 0;
					else
						lptemp = listp.pollFirst();

					if (listm.size() == 0)
						lmtemp = 0;
					else
						lmtemp = listm.pollFirst();

					if (lmtemp == 0)
						printnum = lptemp;
					else if (lptemp == 0)
						printnum = lmtemp;
					else {

						if (makeabs(lmtemp) <= makeabs(lptemp))
							printnum = lmtemp;
						else
							printnum = lptemp;
					}
					sb.append(printnum).append("\n");

				}
			} else {
				if (order > 0) {
					if (listp.size() == 0)
						listp.add(order);
					else {
						for (int j = 0; j < listp.size(); j++) {
							if (j != listp.size() - 1) {
								if (listp.get(j) > order) {
									listp.add(j - 1, order);
									break;
								}
							}
							else {listp.addLast(order);break;}
						}
					}
				} else {
					if (listm.size() == 0)
						listm.add(order);
					else {
						for (int j = 0; j < listp.size(); j++) {
							if (listp.get(j) < order) {
								listp.add(j - 1, order);
								break;
							}
						}
					}
				}
			}
			System.out.println(sb);

		}

	}

	public static int makeabs(int num) {
		if (num < 0)
			return -num;
		else
			return num;
	}
}
