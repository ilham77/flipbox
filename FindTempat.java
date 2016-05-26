/*
	Ilham Akbar
	77.ilham.77@gmail.com
*/

public class FindTempat{

	public ArrayList<String> search(String q){
		ArrayList<String> suggestion = new ArrayList<>();
		String[] query = q.toLowerCase().split(" ");
		for (String q : query){
			Connection con; //koneksi ke database yang menyimpan data tempat2 yang bisa dicari
			PreparedStatement query = con.prepareStatement("select * from tempat where tag like %" + q + "%"); //diasumsikan terdapat tabel 'tempat' yang berisi informasi tempat2 yang bisa dicari, beserta tag yang relevan dengan tempat itu
			ResultSet hasil = query.executeQuery();

			while (hasil.next()){
				if (suggestion.contains(hasil.getString("nama"))){
					suggestion.add(hasil.getString("nama")); //menyimpan nama tempat, dengan asumsi terdapat kolom 'nama'
				}
			}
		}

		return suggestion;
	}

}