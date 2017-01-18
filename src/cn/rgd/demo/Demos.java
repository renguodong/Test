package cn.rgd.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demos {
	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		Stream<String> stream = list.stream();
		List<String> l = stream.skip(3).limit(2).collect(Collectors.toList());
		l.forEach((z) -> System.out.println(z));
//		DoubleSummaryStatistics ds = list.stream().mapToDouble((x) -> x.getAge() * 12).summaryStatistics();
//		System.out.println(ds.getMax());
	}
}

