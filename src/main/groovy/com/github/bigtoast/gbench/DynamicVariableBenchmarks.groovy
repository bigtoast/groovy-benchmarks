package com.github.bigtoast.gbench

import com.google.caliper.SimpleBenchmark

class DynamicVariableBenchmarks {

	public static class DynamicVariableBenchmark extends SimpleBenchmark {
	
		def key = "test_key_"
		Map<String,Integer> testMap = [:]
		
		@Override public void setUp(){
			50.times { it ->
				testMap.put( key + it, it )
			}
		}
		
		public void timeDirectCall( int reps ){
			
		}	
		
		public void timeDynamicCall( int reps ){
			
		}
		
	}
	
}
