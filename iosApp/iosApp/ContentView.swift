import SwiftUI
import lhfile

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    var body: some View {
        
        Button("--> Hello world!", action: {
            let pathDir = FileManager.default.urls(
                for: .documentDirectory,
                in: .userDomainMask
            )[0].appendingPathComponent("lhfile")
            
            let lhFile = LHFileTest(pathFile: "\(pathDir.path)/kmm_file_io.test")
            lhFile.write(data: "Hello world!")
            lhFile.read()
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
