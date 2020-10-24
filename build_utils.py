import os


def get_dirs():
    """
    This method expects src/ to be present in the directories which want to
    be compiled and tested.
    It creates the paths to the files from the current working directory
    so that it can be compiled from the current working directory.
    :return: dictionary containing directories as keys and the files inside src/.
    """
    compilable_files = {}
    for a, b, c in os.walk(os.getcwd()):
        if "src" in a:
            compilable_files[a] = [os.path.join(a, _file) for _file in c]
    print(compilable_files)
    return compilable_files
