use iui::controls::Button;
use iui::prelude::{Window, WindowType};
use iui::UI;

fn main() {
    println!("Hol' up, checking for updates.");

    // UI init
    let ui = UI::init().unwrap();

    // Widgets init
    let mut button = Button::new(&ui, "Ok");

    // Uhhhh idk
    let mut grid = LayoutGird::new(&ui);
    grid.set_padded(&ui, true);
    let mut window = Window::new(&ui, "OakLauncher Updater", 640, 480, WindowType::HasMenubar);
    window.set_child(&ui, grid);
    window.show(&ui);

    ui.main();
}
