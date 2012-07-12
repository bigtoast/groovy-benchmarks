package com.github.bigtoast.gbench

import com.google.caliper.SimpleBenchmark
import com.google.caliper.Runner

class ConstructorBenchmarks {
	
	public static class Duder {
		String name
		Integer age
		
		public Duder( String name, Integer age ) {
			this.name = name
			this.age = age
		}		
	}
	
	public static class DuderSansConstructor {
		String name
		Integer age
	}
	
	public static class ConstructorBenchmark extends SimpleBenchmark {
		
		String dude = 'Duder McGee'
		
		public void timeStandardConstructor( int reps ) {
			for ( int i = 0; i < reps; i++ ) {
				new Duder(dude, i)
			}
		}
		
		public void timeNamedConstructor( int reps ) {
			for ( int i = 0; i < reps; i++ ) {
				new DuderSansConstructor(age:i, name:dude)
			}
		}
		
		public void timeMapConstructor( int reps ) {
			for ( int i = 0; i < reps; i++ ) {
				new DuderSansConstructor([age:i, name:dude])
			}
		}
		
	}
	
	public static void main( String... args ) throws Exception {
		Runner.main( ConstructorBenchmark.class, args )
	}

}
