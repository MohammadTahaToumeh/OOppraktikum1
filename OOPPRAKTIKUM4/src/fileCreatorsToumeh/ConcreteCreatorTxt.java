package fileCreatorsToumeh;

import java.io.IOException;

public class ConcreteCreatorTxt extends ReaderCreatorToumeh {

	@Override
	public ReaderProductToumeh factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteProductTxt();
	}
	
}
