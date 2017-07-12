package com.ziumks.common.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ziumks.common.base.Bus;

public class Item<T> {
	public int no;
	public int pno;
	public T name;

	public int depth;
	public List<Item<T>> itemz;

	public Item(int no, int pno, T name) {
		this.no = no;
		this.pno = pno;
		this.name = name;

		depth = 0;
		itemz = new ArrayList<Item<T>>();
	}
	
	public Item(Bus temp){
		this.pno = Integer.parseInt( temp.getString("hgrk_ptfl_id") );
		this.no = Integer.parseInt( temp.getString("unfy_ptfl_id") );
		this.name = (T) temp.getString("ptfl_rduc_nm");
		depth = 0;
		itemz = new ArrayList<Item<T>>();
	}

	public int size() {
		return itemz.size();
	}

	public void add(Item<T> item) {
		if (no == item.pno) {
			item.depth = depth + 1;
			Iterator<Item<T>> iterInner = itemz.iterator();
			boolean alreadyExist = false;
			while (iterInner.hasNext()) {
				if( iterInner.next().no == item.no) {
					alreadyExist = true;
					break;
				}
			}
			if( !alreadyExist ){
				itemz.add(item);
			}
			return;
		}

		Iterator<Item<T>> iter = itemz.iterator();
		while (iter.hasNext()) {
			iter.next().add(item);
		}
	}

	public String toString() {


		StringBuffer sb = new StringBuffer();

		for (int i = 0, n = depth * 4; i < n; i++) {
			sb.append(" ");
		}
		// jstree 용 
		sb.append("<a href=\"#\">");

		sb.append(name);

		sb.append("</a>");
		return sb.toString();
	}
}
   
