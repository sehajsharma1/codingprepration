package oak.codingprepration.java8;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StreamPractice 
{
	Logger logger=Logger.getLogger("StreamPractice");
	public static void main(String[] args)
	{
		new StreamPractice().functionalInterfaceAndLambdaExpression();
		
		
		
		
	}
	private void  functionalInterfaceAndLambdaExpression()
	{
		
		List<Integer> number = List.of(2,3,4,511,22,33,1,9);
		int minimum;
		int sum;
		int maximum;
		minimum=number.stream().min(Comparator.naturalOrder()).get();
		logger.info("minimum number using min method and Comparator.naturalOrder():"+minimum);
		minimum=number.stream().min(Integer::compare).get();
		logger.info("minimum number using min method and Integer::compare:"+minimum);
		minimum=number.stream().mapToInt(value->value).min().getAsInt();
		logger.info("minimum number using mapToInt method "+minimum);
		sum=number.stream().mapToInt(value->value).sum();
		logger.info("sum of number using mapToInt method "+sum);
		maximum=number.stream().max(Integer::compare).get();
		logger.info("sum of number using max method and Integer::compare"+maximum);
		number =number.stream().sorted().collect(Collectors.toList());
		logger.info("sorted list using sorted() "+number);
		number =number.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		logger.info("sorted list using sorted() in decreasing order "+number);
		number =number.stream().filter(value->value%2==0).collect(Collectors.toList());
		logger.info("even number list "+number);
		number =List.of(2,3,4,511,22,33,1,9).stream().filter(value->value%2!=0).collect(Collectors.toList());
		logger.info("odd number list "+number);
		sum=number.stream().reduce((o1,o2)->Integer.sum(o1, o2)).get();
		logger.info("sum of number using reduce function "+sum);
		number=List.of(2,3,4,511,22,33,1,9).stream().map(value->value-1).collect(Collectors.toList());
		logger.info("functional interfae "+number);
		List.of(2,3,4,511,22,33,1,9).stream().forEach(value->{if(value==2)logger.info("consumer");});
		
		
	}

}