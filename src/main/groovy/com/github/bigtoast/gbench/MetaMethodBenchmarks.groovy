package com.github.bigtoast.gbench

import com.google.caliper.SimpleBenchmark
import com.google.caliper.Runner

class MetaMethodBenchmarks {
	
	public static class Duder {
		String name
		Integer age
		
		public Duder( String name, Integer age ) {
			this.name = name
			this.age = age
		}	
		
		Integer timesAge( Integer i ){ age * i }	
	}
	
	public static class MetaMethodBenchmark extends SimpleBenchmark {
		
		Duder duder 
			
		@Override
		protected void setUp(){
			Duder.metaClass.metaTimesAge << { Integer i -> delegate.age * i }
			duder = new Duder('Duder McGee', 666)
		}
		
		public void timeDirectCall( int reps ) {
			for ( int i = 0; i < reps; i++ ) {
				duder.timesAge( i )
			}
		}
		
		public void timeMetaCall( int reps ) {
			for ( int i = 0; i < reps; i++ ) {
				duder.metaTimesAge( i )
			}
		}
		
		public void timeDynamicDirectCall( int reps ) {
			for ( int i = 0; i < reps; i++ ) {
				duder."timesAge"( i )
			}
		}
		
		public void timeDynamicMetaCall( int reps ) {
			for ( int i = 0; i < reps; i++ ) {
				duder."metaTimesAge"( i )
			}
		}
		
	}
	
	public static void main( String... args ) throws Exception {
		Runner.main( MetaMethodBenchmark.class, args )
	}

}

