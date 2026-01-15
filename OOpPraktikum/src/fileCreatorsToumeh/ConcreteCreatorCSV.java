package fileCreatorsToumeh;

import java.io.IOException;

public class ConcreteCreatorCSV extends ReaderCreatorToumeh{

	@Override
	public ReaderProductToumeh factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteProductCSV();
	}

}
